using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace C____0005
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        static string Path = null;
        public MainWindow()
        {
            InitializeComponent();
        }

        private void MenuItem_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.ShowDialog();
            Path = ofd.FileName;
            TextRange a = new TextRange(richtextbox.Document.ContentStart, 
                richtextbox.Document.ContentEnd);
            a.Text = File.ReadAllText(Path, Encoding.UTF8);
        }

        private void MenuItem_Click_1(object sender, RoutedEventArgs e)
        {
            TextRange a = new TextRange(richtextbox.Document.ContentStart, 
                richtextbox.Document.ContentEnd);
            if (a.Text.Length != 0)
            {
                if (MessageBox.Show("是否保存当前文本？", "提示", 
                    MessageBoxButton.YesNo,MessageBoxImage.Information) == MessageBoxResult.Yes)
                {
                    SaveFileDialog sfd = new SaveFileDialog();
                    sfd.ShowDialog();
                    Path = sfd.FileName;
                    FileStream fs = new FileStream(Path, FileMode.Create);
                    StreamWriter sw = new StreamWriter(fs);
                    //开始写入
                    sw.Write(a.Text);
                    //清空缓冲区
                    sw.Flush();
                    //关闭流
                    sw.Close();
                    fs.Close();
                }
                richtextbox.Document.Blocks.Clear();
            }
        }

        private void MenuItem_Click_2(object sender, RoutedEventArgs e)
        {
            TextRange a = new TextRange(richtextbox.Document.ContentStart, richtextbox.Document.ContentEnd);
            if (a.Text.Length != 0)
            {
                
                if(Path == null)
                {
                    SaveFileDialog sfd = new SaveFileDialog();
                    sfd.ShowDialog();
                    Path = sfd.FileName;
                }
                FileStream fs = new FileStream(Path, FileMode.Create);
                StreamWriter sw = new StreamWriter(fs);
                //开始写入
                sw.Write(a.Text);
                //清空缓冲区
                sw.Flush();
                //关闭流
                sw.Close();
                fs.Close();
            }
        }

        private void MenuItem_Click_3(object sender, RoutedEventArgs e)
        {
            TextRange a = new TextRange(richtextbox.Document.ContentStart, richtextbox.Document.ContentEnd);
            if (a.Text.Length != 0)
            {
            SaveFileDialog sfd = new SaveFileDialog();
            sfd.ShowDialog();
            Path = sfd.FileName;
            FileStream fs = new FileStream(Path, FileMode.Append);
            StreamWriter sw = new StreamWriter(fs);
            //开始写入
            sw.Write(a.Text);
            //清空缓冲区
            sw.Flush();
            //关闭流
            sw.Close();
            fs.Close();
            }
        }

        private void Boldbutton_Click(object sender, RoutedEventArgs e)
        {
            FontWeight fontWeight = new FontWeight();
            fontWeight = richtextbox.FontWeight;
            bool statue = boldbutton.IsPressed;
            if(statue)
            {
                richtextbox.FontWeight = fontWeight;
            }
            else
            richtextbox.Selection.ApplyPropertyValue(TextElement.FontWeightProperty,FontWeights.Bold);
        }

        private void Xiebutton_Click(object sender, RoutedEventArgs e)
        {
            richtextbox.Selection.ApplyPropertyValue(TextElement.FontStyleProperty,FontStyles.Italic);
        }

        private void Underbutton_Click(object sender, RoutedEventArgs e)
        {
            richtextbox.Selection.ApplyPropertyValue(TextElement.FontStyleProperty, FontStyles.Normal); 
        }
    }
}
