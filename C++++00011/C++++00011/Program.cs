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
            Boolean flag = true;
            while (flag)
            {
                Console.Title = "C#第一课迭代法";//设置标题
                Console.ForegroundColor = ConsoleColor.Green; //设置字体颜色为绿色 
                Console.Write("请输入循环精度：");
                double n = Convert.ToDouble(Console.ReadLine());
                Fibanacci(n);           
                Tylor(n);
                Vieta(n);
                Console.Write("是否继续？Y or N?");
                string num = Console.ReadLine();
                if (num == "N" || num == "n")
                    flag = false;
            }
        }



        static void Fibanacci(double n)
        {
            int num = n.ToString().Length;//迭代精度的字符串长度作为斐波那契的第几项
            Int64 fibanacci1 = 1, fibanacci = 1;
            if (num == 1 || num == 2)
                Console.WriteLine("Fibanacci:{0}", 1);
            else
            {
                for (int i = 2; i < num; i++)
                {
                    fibanacci = fibanacci + fibanacci1;
                    fibanacci1 = fibanacci - fibanacci1;
                }
                Console.WriteLine("Fibanacci第{0}项:{1}", num,fibanacci);
            }
        }



        static void Vieta(double n)
        {
            int times = 0;
            double num = 1, num1 = 0;
            for (int i = 0; i < 10000; i++)
            {
                num1 = Math.Sqrt(num1 + 2.0);
                num = num * num1 * 0.5;
                times++;
                if (Math.Abs(2.0 / num - 2.0 / num1) <= n)
                    i = 10001;
            }
            num = 2.0 / num;

            Console.WriteLine("π:{0}    times:{1}", num,times);
        }



        static void Tylor(double n)
        {
            int times = 0;
            double e = 2, num = 1;
            for (int i = 2; i <= 10000; i++)
            {
                for (int j = 1; j <= i; j++)
                {
                    num = j * num;times++;
                }
                e = e + 1 / num;
                if (Math.Abs(1 / num) <= n)
                    i = 10001;
                    num = 1;
            }
            Console.WriteLine("e:{0}    times:{1}", (e - 1/num),times);
        }
    }
}