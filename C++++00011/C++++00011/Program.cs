using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace C____001
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
<<<<<<< HEAD
                Console.Title = "C#第一课迭代法";//设置标题
                Console.ForegroundColor = ConsoleColor.Red; //设置字体颜色为红色 
=======
>>>>>>> parent of 0c1517d... 添加是否继续判断
                Console.Write("请输入循环次数：");
                int n = Convert.ToInt16(Console.ReadLine());
                Fibanacci(n);
                Tylor(n);
                Vieta(n);
<<<<<<< HEAD
                Console.Write("是否继续？Y or N?");
                string num = Console.ReadLine();
                if ( num == "N" || num == "n")
                    flag = false;
=======
                Console.ReadKey();
>>>>>>> parent of 0c1517d... 添加是否继续判断
            }
        }

        static void Fibanacci(int n)
        {
            Int64 fibanacci1 = 1, fibanacci = 1;
            if (n == 1 || n == 2)
                Console.Write("Fibanacci:{0}", 1);
            else
            {
                for (int i = 2; i < n; i++)
                {
                    fibanacci = fibanacci + fibanacci1;
                    fibanacci1 = fibanacci - fibanacci1;
                }
                Console.WriteLine("Fibanacci:{0}", fibanacci);
            }
        }

        static void Vieta(int n)
        {
            double num = 1, num1 = 0;
            for (int i = 0; i < n; i++)
            {
                num1 = Math.Sqrt(num1 + 2.0);
                num = num * num1 * 0.5;
            }
            num = 2.0 / num;
            Console.WriteLine("π:{0}", num);
        }

        static void Tylor(int n)
        {
            double e = 2, num = 1;
            for (int i = 2; i <= n; i++)
            {
                for (int j = 1; j <= i; j++)
                {
                    num = j * num;
                }
                e = e + 1 / num;
                num = 1;
            }
            Console.WriteLine("e:{0}", e);
        }
    }
}
