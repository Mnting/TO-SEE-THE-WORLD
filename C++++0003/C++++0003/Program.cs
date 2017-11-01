using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace C____0003
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Title = "全都是交通工具啊！";

            Vehicle vehicle;
            vehicle = new Minitruck();
            ICargo cargo;
            cargo = (ICargo)vehicle;
            Console.WriteLine("此时车上有{0}kg货物",cargo.Weight);
            /*
             * 上面的vehicle相当于Minitruck的引用，
             * 把他强转成接口后，就限制了用户的访问权限，只能访问该接口下的内容
             */
            Console.WriteLine();
            Truck truck = new Truck();
            Console.Write("请输入本站上车人数：");
            truck.Number = Convert.ToInt32(Console.ReadLine());
            Console.Write("请输入本站装货重量：");
            truck.Weight = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("本站共上车{0}人",truck.Number);
            Console.WriteLine("本站共装货{0}kg", truck.Weight);
            truck.Start();
            Console.WriteLine();
            Limousine limousine = new Limousine();
            limousine.Number = 10;
            limousine.Stop();
            Console.Write("下车的小朋友人数：");
            limousine.Number = limousine.Number - Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("车上还有{0}个小朋友",limousine.Number);
        }
    }

    abstract class Vehicle //交通工具
    {
        public abstract void Start();
        public abstract void Stop();
    }

    abstract class Train : Vehicle,IManned,ICargo
    {
        private int number;
        private int weight;
        public Train()
        {
            Console.WriteLine("调用了火车构造！");
        }

        public int Number
        {
            set { number = value; }
            get { return number; }
        }

        public int Weight {
            set { weight = value; }
            get { return weight; }
        }

        public override void Start()
        {
            Console.WriteLine("火车开车啦！");
        }

        public override void Stop()
        {
            Console.WriteLine("火车停车啦！");
        }
    }

    class Coach : Train //客车
    {
        public Coach()
        {
            Console.WriteLine("这是金龙客车~");
        }

        public override void Start()
        {
            Console.WriteLine("客车开车啦！");
        }

        public override void Stop()
        {
            Console.WriteLine("客车停车啦！");
        }
    }

    class Truck : Train//货车
    {
        public Truck()
        {
            Console.WriteLine("这是东风货车。");
        }

        public override void Start()
        {
            Console.WriteLine("货车开车啦！");
        }

        public override void Stop()
        {
            Console.WriteLine("货车停车啦！");
        }
    }

    class Car : Vehicle,IManned,ICargo
    {
        private int number;
        private int weight;
        public Car()
        {
            Console.WriteLine("调用了汽车构造~");
        }

        public int Number
        {
            set { number = value; }
            get { return number; }
        }

        public int Weight
        {
            set { weight = value; }
            get { return weight; }
        }

        public override void Start()
        {
            Console.WriteLine("开车啦！");
        }

        public override void Stop()
        {
            Console.WriteLine("停车啦！");
        }
    }

    class Limousine : Car//豪华轿车
    {
        public Limousine()
        {
            Console.WriteLine("这是豪华轿车！敞篷的！");
        }
        
        public override void Start()
        {
            Console.WriteLine("去兜风！");
        }

        public override void Stop()
        {
            Console.WriteLine("回来啦！");
        }
    }

    class Minitruck : Car
    {
        public Minitruck()
        {
            Console.WriteLine("迷你货车，就是小货车啊。");
        }

        public override void Start()
        {
            Console.WriteLine("mini开车啦！");
        }

        public override void Stop()
        {
            Console.WriteLine("mini停车啦！");
        }
    }

    interface IManned
    {
        int Number { set; get; }
    }

    interface ICargo
    {
        int Weight { set; get; }
    }
}