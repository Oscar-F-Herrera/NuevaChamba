package evidencia2.utils.collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Kruskal
{
    /**
     * Clase Kruskal para el problema del árbol
     */
    public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

    public  int [][] M;
    public int [][] t;
    public boolean [][] in;
    public boolean [][] temp;

    static int n;
    static int mincost = 0;
    public int a, b, num_ed=0;


    /**
     * Aquí se inicia la matriz M y las otras estructuras de datos
     *
     * @param n Número de vértices del grafo
     * @throws IOException si hay un valor invalido
     */
    public Kruskal(int n) throws IOException
    {
        this.M = new int[n+1][n+1];
        this.in = new boolean[n+1][n+1];
        this.t = new int[n+1][3];

        System.out.print("\nDame los costos de las aristas:\n");
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
            {
                in[i][j] = in[j][i] = false;
                if((i < j))
                {
                    System.out.print(i+" al "+j+": ");
                    M[j][i] = M[i][j] = Integer.parseInt(br.readLine());
                    if(M[i][j] == 0 )
                        M[j][i] = M[i][j] = 7001;
                }
                if(i==j)
                    M[i][j]=7001;
            }
    }

    /**
     * Método que resuelve el problema del árbol de expansión mínima
     */
    public void Kruskals()
    {
        for (int i = 1; i<=n; i++)
        {
            getMinKL();
            if(a==b)
                break;
            System.out.print(b + "-" +a);
            if(formscycle(i-1))
            {
                System.out.println(" --> Ya estan en el mismo conjunto");
                i--;
                continue;
            }
            else
                System.out.println();

            mincost = mincost + M[a][b];
            num_ed = (isPresent(i, a))?num_ed:num_ed+1;
            num_ed = (isPresent(i, b))?num_ed:num_ed+1;

            t[i][1] = b;
            t[i][2] = a;
            if(num_ed >= n)
            {
                if(allconnect(i))
                    return;
            }

        }
        System.out.println("\nNo hay solucion");
    }

    public boolean allconnect(int i)
    {
        for(int c=2;c<=n;c++)
        {
            temp = new boolean[n+1][n+1];
            for(int a=1;a<=n;a++)
                for(int b=1;b<=n;b++)
                    temp[a][b] = temp[b][a] = false;

            if(!can_reach(1, c, i))
                return false;
        }
        return true;
    }

    public boolean formscycle(int i)
    {
        if(isPresent(i, a) && isPresent(i, b))
        {
            temp = new boolean[n+1][n+1];
            for(int a=1;a<=n;a++)
                for(int b=1;b<=n;b++)
                    temp[a][b] = temp[b][a] = false;

            return can_reach(a, b, i);
        }
        return false;
    }

    /**
     * /**
     *  * Comprueba si hay un camino entre dos vértices en el grafo
     * @param a primer vertice
     * @param b segundo vertice
     * @param i ciclo actual
     * @return para cuando hay un camino entre los 2
     */
    public boolean can_reach(int a, int b, int i)
    {
        temp[a][b] = temp[b][a] = true;
        for(int o=1; o<=i; o++)
        {
            if(((a == t[o][1]) && (b == t[o][2])) || ((b == t[o][1]) && (a == t[o][2])))
                return true;
            if((a == t[o][1]) && !(temp[t[o][2]][b]) )
            {
                if(can_reach(t[o][2], b, i))
                    return true;
            }
            else if((a == t[o][2]) && !(temp[t[o][1]][a]))
            {
                if(can_reach(t[o][1], a, i))
                    return true;
            }
        }
        return false;
    }

    public boolean isPresent(int i, int val)
    {
        for(int o=1; o<=i; o++)
            if((val == t[o][1]) || ((val == t[o][2]) ))
                return true;
        return false;
    }

    /**
     * Aquí buscamos aristas mínimas sin visitar en el grafo (M).
     * Actualizamos los vértices a y b con los índices de los extremos de la arista mínima encontrada
     * También marca la arista como visitada en la matriz
     */
    public void getMinKL()
    {
        int a1 = 1, b1 = 1;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
            {
                if((i < j))
                {
                    // Comprueba si la arista (i, j) es más corta que la arista mínima encontrada hasta ahora
                    if((M[i][j] < M[a1][b1]) && M[i][j] !=0 && !in[j][i])
                    {
                        a1 = i;
                        b1 = j;
                    }
                }
            }
        if(M[a1][b1] !=0 )
        {
            a =a1; b=b1;
            in[a][b] = in[b][a] = true;
        }
    }

    /**
     * Aquí ahora sí se inicia el programa
     *
     * @throws IOException por si hay un error de datos
     */
    public static void main (String[] args) throws IOException
    {
        System.out.println("Algoritmo de Kruskal");
        System.out.print("De el numero de vertices: \n");
        n = Integer.parseInt(br.readLine());

        Kruskal kr=new Kruskal(n);

        System.out.println("\n\nSolucion : \n");
        kr.Kruskals();
        System.out.println("\n\n\nEl costo es de: "+ mincost);
    }

}