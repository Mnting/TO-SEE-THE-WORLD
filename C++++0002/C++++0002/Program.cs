using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace C____0002
{
    class Program
    {
        static void Main(string[] args)
        {
            int times = 0;
            Boolean flag = true;
            int count = 0;
            int[] num = new int[1000];
            Console.Title = "找出范围内所有相差为2的素数";
            Console.ForegroundColor = ConsoleColor.Magenta;
            Console.Write("请输入最大范围：");
            int n = Convert.ToInt16(Console.ReadLine());
            for (int i = 3; i < n; i++)
            {
                for (int j = 2; j <= Math.Sqrt(i); j++)
                {
                    if (i % j == 0)
                    {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                {
                    count++;
                    doublenumber(ref times, i, count, ref num);
                }
                else
                {
                    flag = true;
                }
            }
        }

        static void doublenumber(ref int times, int i, int count, ref int[] num)
        {

            num[count] = i;
            if (count > 0)
            {
                if ((num[count] - num[count - 1]) == 2)
                {
                    times++;
                    if (times == 5)
                    {
                        Console.WriteLine("{0}and{1} ", num[count - 1], num[count]); times = 0;
                    }
                    else
                        Console.Write("{0}and{1} ", num[count - 1], num[count]);
                }
            }
        }
    }
}
