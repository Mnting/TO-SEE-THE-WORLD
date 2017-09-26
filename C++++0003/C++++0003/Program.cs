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
            Train train = new Train();
            Console.Write("请输入本站上车人数：");
            train.Number = Convert.ToInt32(Console.ReadLine());
            Console.Write("请输入本站装货重量：");
            train.Weight = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("本站共上车{0}人",train.Number);
            Console.WriteLine("本站共装货{0}kg", train.Weight);
            train.Start();
            Console.WriteLine();
            Limousine limousine = new Limousine();
            limousine.Number = 10;
            limousine.Stop();
            Console.Write("下车的小朋友人数：");
            limousine.Number = limousine.Number - Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("车上还有{0}个小朋友",limousine.Number);
        }
    }

    abstract class vehicle //交通工具
    {
        public abstract void Start();
        public abstract void Stop();
    }

    class Train : vehicle,IManned,ICargo
    {
        private int number;
        private int weight;
        public Train()
        {
            Console.WriteLine("这是和谐号火车！");
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

    class Coach : vehicle ,ICargo,IManned//客车
    {
        private int number;
        private int weight;
        public Coach()
        {
            Console.WriteLine("这是金龙客车~");
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
            Console.WriteLine("客车开车啦！");
        }

        public override void Stop()
        {
            Console.WriteLine("客车停车啦！");
        }
    }

    class Truck : vehicle,ICargo//货车
    {
        private int weight;
        public Truck()
        {
            Console.WriteLine("这是东风货车。");
        }

        public int Weight
        {
            set { weight = value; }
            get { return weight; }
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

    class Car : vehicle,IManned
    {
        private int number;
        public Car()
        {
            Console.WriteLine("这是汽车~");
        }

        public int Number
        {
            set { number = value; }
            get { return number; }
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

    class Limousine : vehicle,IManned//豪华轿车
    {
        private int number;
        public Limousine()
        {
            Console.WriteLine("这是豪华轿车！敞篷的！");
        }

        public int Number
        {
            set { number = value; }
            get { return number; }
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

    class Minitruck : vehicle,IManned
    {
        private int number;
        public Minitruck()
        {
            Console.WriteLine("迷你货车，就是小货车啊。");
        }

        public int Number
        {
            set { number = value; }
            get { return number; }
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
