
public class Matrix
{

    private int rows;

    public int getRows()
    {
        return this.rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }


    private int columns;

    public int getColumns()
    {
        return this.columns;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }


    private Complex[][] data;

    public void setData(Complex[][] data)
    {
        this.data = data;
    }
    public  Complex[][] getData()
    {
        return this.data;
    }


    Matrix(int rows_count, int columns_count)
    {
        this.rows = rows_count;
        this.columns = columns_count;
        this.data = new Complex[rows_count][columns_count];
        for(int i = 0; i < rows_count; ++i)
        {
            for(int j = 0; j < columns_count; ++j)
            {
                this.data[i][j] = new Complex();
            }
        }
    }


    Matrix()
    {
        this(3,3);
    }
    Matrix(int rows_count, int columns_count, Complex a)
    {
        this.rows = rows_count;
        this.columns = columns_count;
        this.data = new Complex[rows_count][columns_count];
        for(int i = 0; i < rows_count; ++i)
        {
            for(int j = 0; j < columns_count; ++j)
            {
                this.data[i][j] = a;
            }
        }
    }

    public Matrix add(Matrix b)
    {

        if(this.rows == b.rows && this.columns == b.columns)
        {

            Matrix temp = new Matrix(this.rows, this.columns);
            for(int i = 0; i < this.rows; ++i)
            {
                for(int j = 0; j < this.columns; ++j)
                {
                    temp.data[i][j] = this.data[i][j].add(b.data[i][j]);
                }
            }
            return temp;
        }
        else
        {
            System.out.println("Неверные размеры матриц");
            return this;
        }
    }


    public Matrix sub(Matrix b)
    {

        if(this.rows == b.rows && this.columns == b.columns)
        {
            Matrix temp = new Matrix(this.rows, this.columns);
            for(int i = 0; i < this.rows; ++i)
            {
                for(int j = 0; j < this.columns; ++j)
                {
                    temp.data[i][j] = this.data[i][j].sub(b.data[i][j]);
                }
            }
            return temp;
        }
        else
        {
            System.out.println("Неверные размеры матриц");
            return this;
        }
    }

    public Matrix mul(Matrix b)
    {
        if(this.columns == b.rows)
        {
            Complex a = new Complex(0,0);
            Matrix temp = new Matrix(this.rows, b.columns,a);
            for(int i = 0; i < this.rows; ++i)
            {
                for(int j = 0; j < b.columns; ++j)
                {
                    for(int k = 0; k < b.rows; ++k)
                    {
                        temp.data[i][j] = temp.data[i][j].add(this.data[i][k].mul(b.data[k][j]));
                    }
                }
            }
            return temp;
        }
        else
        {
            System.out.println("Неверные размеры матриц");
            return this;
        }
    }

    public Matrix transpose()
    {
        Matrix temp = new Matrix(this.columns, this.rows);
        for(int i = 0; i < this.rows; ++i)
        {
            for (int j = 0; j < this.columns; ++j) {
                temp.data[j][i] = this.data[i][j];
            }
        }
        return temp;
    }

    public Complex[][] gensubarr(Complex[][] a, int b, int c)
    {
        Complex[][] subarr = new Complex[b - 1][b - 1];
        for(int i = 1; i < b; ++i)
        {
            int j1 = 0;
            for(int j = 0; j < b; ++j)
            {
                if(j == c)
                {
                    continue;
                }
                subarr[i - 1][j1] = a[i][j];
                j1++;

            }
        }
        return subarr;
    }

    public Complex determinant(Complex[][] a, int n)
    {
        Complex ans = new Complex(0,0);
        if (n == 1)
        {
            ans = a[0][0];
        }
        if(n == 2)
        {
            ans = (a[0][0].mul(a[1][1])).sub(a[1][0].mul(a[0][1]));

        }
        if (n > 2)
        {
            for(int i = 0; i < n; ++i)
            {
                Complex[][] temp = gensubarr(a, n, i);
                Complex t = new Complex(Math.pow(-1.0, i + 2.0), 0);
                ans = ans.add(t.mul(a[0][i].mul(determinant(temp, n-1))));
            }

        }

        return ans;

    }

    public void print()
    {
        for(int i = 0; i < this.rows; ++i)
        {
            for(int j = 0; j < this.columns; ++j)
            {
                this.data[i][j].PrAbsForm();
            }
            System.out.println("");
        }
    }
}
