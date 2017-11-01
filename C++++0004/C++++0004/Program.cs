using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace C____0004
{
    class Program
    {
        
        static string[] order = { "1.milk", "2.egg", "3.vegetable", "4.meat", "5.fruit" };
        static double[] cost = {2.0,1.5,3.0,6.0,2.5};
        static int num=0, what=0;
         public class Card
        {
            private double balance = 0;
            public double Balance
            {
                set { balance = balance + value; }
                get { return balance; }
            }
        }

        abstract public class User
        {
            public string name;
        }

        public class ReadCardMachine
        {
            private double money;
            public double Money
            {
                set { this.money = value; }
            }
            public void ShowCost()
            {
                Console.WriteLine("总价：{0}", money);
            }
            public void WriteCard(Card card)
            {
                if(card.Balance<money)
                {
                    Console.WriteLine("余额不足！");
                    Console.WriteLine();
                }
                else
                {
                     card.Balance = card.Balance - money;
                     Console.WriteLine("支付完成");
                     Console.WriteLine("余额：{0}", card.Balance);
                     Console.WriteLine();
                }
            }
        }

        public class Student : User, IPay
        {
            Card mycard;
            public Student(Card card,string name)
                {
                this.name = name;
                mycard = card;
                }
            public void PayCard(ReadCardMachine rcm)
            {
                rcm.WriteCard(mycard);
            }
        }

        public class CanteenAunt : User,IShow
        {
            public void InputHowMuch(ReadCardMachine rcm)
            {
                Random ra = new Random(unchecked((int)DateTime.Now.Ticks));
                double yourcost = 0;
                int flag = 1;
                while (flag == 1)
                {
                   // Console.WriteLine("请输入您想买的食物序号：");
                    what = ra.Next(1, 5);
                    //Console.WriteLine("请输入您想购买的数量：");
                    num = ra.Next(1, 20);
                    Console.WriteLine("已点{0}份{1}", num, order[what]);
                    yourcost = yourcost + cost[what] * num;
                   // Console.WriteLine("继续点餐输入1结束点餐输入0：");
                    flag = ra.Next(-1, 2);
                }
                rcm.Money = yourcost;
                rcm.ShowCost();
            }
        }

        interface IShow
        {
            void InputHowMuch(ReadCardMachine rcm);
        }

        interface IPay
        {
            void PayCard(ReadCardMachine rcm);
        }
        static void Main(string[] args)
        {
            Random ra = new Random(unchecked((int)DateTime.Now.Ticks));
            Console.Write("今日菜谱：");
            foreach (var v in order)
                Console.Write("  {0}", v);
            Console.WriteLine();
                Card card1 = new Card();
            card1.Balance = ra.Next(0,500);
            Student stu1 = new Student(card1,"xiaoming");
            CanteenAunt aunt = new CanteenAunt();
            ReadCardMachine rcm = new ReadCardMachine();
            Console.WriteLine("轮到{0}点餐",stu1.name);
            aunt.InputHowMuch(rcm);
            stu1.PayCard(rcm);

            Card card2 = new Card();
            card1.Balance = ra.Next(0, 500);
            Student stu2 = new Student(card2, "xiaogang");
            CanteenAunt aunt2 = new CanteenAunt();
            Console.WriteLine("轮到{0}点餐", stu2.name);
            aunt.InputHowMuch(rcm);
            stu2.PayCard(rcm);

            Card card3 = new Card();
            card1.Balance = ra.Next(0, 500);
            Student stu3 = new Student(card3, "xiaogou");
            CanteenAunt aunt3 = new CanteenAunt();
            Console.WriteLine("轮到{0}点餐",stu3.name);
            aunt.InputHowMuch(rcm);
            stu3.PayCard(rcm);

            Card card4 = new Card();
            card1.Balance = ra.Next(0, 500);
            Student stu4 = new Student(card4, "xiaogou2");
            CanteenAunt aunt4 = new CanteenAunt();
            Console.WriteLine("轮到{0}点餐", stu4.name);
            aunt.InputHowMuch(rcm);
            stu4.PayCard(rcm);

            Card card5 = new Card();
            card1.Balance = ra.Next(0, 500);
            Student stu5 = new Student(card5, "xiaogou3");
            CanteenAunt aunt5 = new CanteenAunt();
            Console.WriteLine("轮到{0}点餐", stu5.name);
            aunt.InputHowMuch(rcm);
            stu5.PayCard(rcm);

            Card card6 = new Card();
            card1.Balance = ra.Next(0, 500);
            Student stu6 = new Student(card6, "xiaogou4");
            CanteenAunt aunt6 = new CanteenAunt();
            Console.WriteLine("轮到{0}点餐", stu6.name);
            aunt.InputHowMuch(rcm);
            stu6.PayCard(rcm);

            Card card7 = new Card();
            card1.Balance = ra.Next(0, 500);
            Student stu7 = new Student(card7, "xiaogou5");
            CanteenAunt aunt7 = new CanteenAunt();
            Console.WriteLine("轮到{0}点餐", stu7.name);
            aunt.InputHowMuch(rcm);
            stu7.PayCard(rcm);

            Card card8 = new Card();
            card1.Balance = ra.Next(0, 500);
            Student stu8 = new Student(card8, "xiaogou6");
            CanteenAunt aunt8 = new CanteenAunt();
            Console.WriteLine("轮到{0}点餐", stu8.name);
            aunt.InputHowMuch(rcm);
            stu8.PayCard(rcm);

            Card card9 = new Card();
            card1.Balance = ra.Next(0, 500);
            Student stu9 = new Student(card9, "xiaogou7");
            CanteenAunt aunt9 = new CanteenAunt();
            Console.WriteLine("轮到{0}点餐", stu9.name);
            aunt.InputHowMuch(rcm);
            stu9.PayCard(rcm);

            Card card10 = new Card();
            card1.Balance = ra.Next(0, 500);
            Student stu10 = new Student(card10, "xiaogou8");
            CanteenAunt aunt10 = new CanteenAunt();
            Console.WriteLine("轮到{0}点餐", stu10.name);
            aunt.InputHowMuch(rcm);
            stu10.PayCard(rcm);
        }
    }
}
