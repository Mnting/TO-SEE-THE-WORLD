using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace sql
{
    public class Node<T>
    {
        private T name;
        private T type;
        private T condition;
        private Node<T> next;

        //构造器：数据域+引用域，普通结点
        public Node(T name,T type,T condition, Node<T> p)
        {
            this.name = name;
            this.type = type;
            this.condition = condition;
            next = p;
        }

        //构造器：引用域，头结点
        public Node(Node<T> p)
        {
            next = p;
        }



        //构造器：数据域，尾结点
        public Node(T name, T type, T condition)
        {
            this.name = name;
            this.type = type;
            this.condition = condition;
            next = null;
        }

        //构造器：无参数
        public Node()
        {
            name = default(T);
            type = default(T);
            condition  = default(T);
            next = null;
        }

        //构造域属性
        public T Name
        {
            set { name = value; }
            get { return name; }
        }

        public T Type
        {
            set { type = value; }
            get { return type; }
        }
        
        public T Condition
        {
            set { condition = value; }
            get { return condition; }
        }

        //构造引用域
        public Node<T> Next
        {
            set { next = value; }
            get { return next; }
        }
    }

    public class LinkList<T>
    {
        private Node<T> head;//单链表的头结点

        //头节点属性
        public Node<T> Head
        {
            set { head = value;}
            get { return head; }
        }

        //构造器
        public LinkList()
        {
            head = null;
        }

        //求单链表的长度
        public int GetLength()
        {
            Node<T> p = head;
            int len = 0;
            while (p != null)
            {
                ++len;
                p = p.Next;
            }
            return len;
        }

        //清空单链表
        public void Clear()
        {
            head = null;
        }

        //判断单链表是否为空
        public bool IsEmpty()
        {
            if(head == null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //在单链表末尾添加新元素
        public void Append(T name,T type,T condition)
        {
            Node<T> q = new Node<T>(name, type, condition);
            Node<T> p = new Node<T>();
            if (head == null)
            {
                head = q;

            }
            else
            {
                p = head;
                while (p.Next != null)
                {
                    p = p.Next;
                }
                p.Next = q;
            }
        }

        //显示链表  
        public void Display()
        {
            Node<T> p = new Node<T>();
            p = this.head;
            while (p != null)
            {
                Console.Write(p.Name + " ");
                p = p.Next;
            }
        }
    }

    public partial class Form1 : Form
    {
        public string text = null;
        public string[] sArray = null;
        public LinkList<string> tablelist = new LinkList<string>();
        public Form1()
        {
            InitializeComponent();
        }

        private void Run_Click(object sender, EventArgs e)
        {
            richTextBox2.Clear();
            sArray = richTextBox1.SelectedText.Split();
            var v = sArray[0];
            switch (v)
            {
                case "create":CreatTable(sArray);break;
                case "select":Select(sArray);break;
            }
            
        }

        public void CreatTable(string[] Array)
        {
            int i = 0,j = 0;
            string[] item = new string[3];
            string tabletext = null;
            item[0] = null; item[1] = null; item[2] = null;
            while (i<Array.Length)
            {
                if(Array[i].Equals("table")||Array[i].Equals("TABLE"))
                {
                    string name = "表名：" + Array[++i];

                    tablelist.Append(Array[i], null, null);i++;
                }
                else if(Array[i++].Equals("("))
                {
                    while(i < Array.Length)
                    {
                    while(!Array[i].Equals(",")&&!Array[i].Equals(")"))
                    {
                        if (j != 3)
                        {
                            item[j++] = Array[i++];
                        }
                       
                    }
                        tablelist.Append(item[0], item[1], item[2]);
                        i++;
                        j = 0;
                        item[0] = null; item[1] = null; item[2] = null;
                    }
                }
            }
            Node<string> p = new Node<string>();
            p = tablelist.Head;
            if (p != null)
            {
                richTextBox2.Text = "表名：" + p.Name + "\n";
                tabletext = "表名：" + p.Name + "\n";
            }
            p = tablelist.Head.Next;
            while (p != null)
            {
                string text = richTextBox2.Text;
                richTextBox2.Text = text + p.Name + "|";
                tabletext = tabletext + p.Name + " " + p.Type + " " + p.Condition + " " + "\n";
                p = p.Next;
            }

            FileStream fs = new FileStream("C:/Users/15229/Desktop/table.txt", FileMode.Create);
            StreamWriter sw = new StreamWriter(fs);
            //开始写入
            sw.Write(tabletext);
            //清空缓冲区
            sw.Flush();
            //关闭流
            sw.Close();
            fs.Close();
        }

        public void Select(string[] Array)
        {
            string[] tabletext = File.ReadAllText("C:/Users/15229/Desktop/table.txt", Encoding.UTF8).Split();
            richTextBox2.Text = tabletext[0];
        }
    }
}
