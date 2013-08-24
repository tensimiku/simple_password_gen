using System;
using System.Collections.Generic;
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
using System.Security.Cryptography;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Text.RegularExpressions;

namespace WpfApplication1
{
    /// <summary>
    /// MainWindow.xaml에 대한 상호 작용 논리
    /// </summary>
    public partial class MainWindow : Window
    {


        double orginalWidth, originalHeight;
        string userinput;


        ScaleTransform scale = new ScaleTransform();
        public MainWindow()
        {
            InitializeComponent();
            this.Loaded += new RoutedEventHandler(Window1_Loaded);
        }
        void Window1_Loaded(object sender, RoutedEventArgs e)
        {
            orginalWidth = this.Width;
            originalHeight = this.Height;

            if (this.WindowState == WindowState.Maximized)
            {
                ChangeSize(this.ActualWidth, this.ActualHeight);
            }

            this.SizeChanged += new SizeChangedEventHandler(Window1_SizeChanged);
        }
        void Window1_SizeChanged(object sender, SizeChangedEventArgs e)
        {
            ChangeSize(e.NewSize.Width, e.NewSize.Height);
        }

        private void ChangeSize(double width, double height)
        {
            scale.ScaleX = width / orginalWidth;
            scale.ScaleY = height / originalHeight;

            FrameworkElement rootElement = this.Content as FrameworkElement;

            rootElement.LayoutTransform = scale;
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            userinput = this.input.Text+"Identify";
            if (this.input.Text.Length == 0)
            {
                this.output.Text = "Having Fun?";
            }
            else if (this.input.Text.ToLower().EndsWith("m5"))
            {
                MD5 md5Hash = MD5.Create();
                this.output.Text = passwordmaker(md5hasher(md5Hash, userinput));
            }
            else if (this.input.Text.ToLower().EndsWith("s1"))
            {
                SHA1 sha1hash = SHA1.Create();
                this.output.Text = passwordmaker(sha1hasher(sha1hash, userinput));
            }
            else if (this.input.Text.ToLower().EndsWith("s2"))
            {
                SHA256 sha256hash = SHA256.Create();
                this.output.Text = passwordmaker(sha256hasher(sha256hash, userinput));
            }
            else
            {
                SHA512 sha512hash = SHA512.Create();
                this.output.Text = passwordmaker(sha512hasher(sha512hash, userinput));
                MD5 md5Hash = MD5.Create();
            }

            
        }
        private string md5hasher(MD5 md5Hash, string input)
        {

            byte[] data = md5Hash.ComputeHash(Encoding.UTF8.GetBytes(input));
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < data.Length; i++)
            {
                sBuilder.Append(data[i].ToString("x2"));
            }
            return sBuilder.ToString();
        }
        private string sha1hasher(SHA1 sha1hash, string input)
        {
            byte[] data = sha1hash.ComputeHash(Encoding.UTF8.GetBytes(input));
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < data.Length; i++)
            {
                sBuilder.Append(data[i].ToString("x2"));
            }
            return sBuilder.ToString();
        }
        private string sha256hasher(SHA256 sha256hash, string input)
        {
            byte[] data = sha256hash.ComputeHash(Encoding.UTF8.GetBytes(input));
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < data.Length; i++)
            {
                sBuilder.Append(data[i].ToString("x2"));
            }
            return sBuilder.ToString();
        }
        private string sha512hasher(SHA512 sha512hash, string input)
        {
            // Convert the input string to a byte array and compute the hash.
            byte[] data = sha512hash.ComputeHash(Encoding.UTF8.GetBytes(input));

            // Create a new Stringbuilder to collect the bytes
            // and create a string.
            StringBuilder sBuilder = new StringBuilder();

            // Loop through each byte of the hashed data 
            // and format each one as a hexadecimal string.
            for (int i = 0; i < data.Length; i++)
            {
                sBuilder.Append(data[i].ToString("x2"));
            }

            // Return the hexadecimal string.
            return sBuilder.ToString();
        }
        private string passwordmaker(string input)
        {
            string front = input.Substring(0, 12).ToLower();
            string back = input.Substring(12, 12).ToUpper();
            string num = "";
            string tmp = "";
            string[] secureletter = new string[] { "!", "@","#","$","%","^","&","*","(",")"};
            for (int i = 0; i < input.Length; i++)
            {
                tmp = input.Substring(i, 1);
                if (Regex.IsMatch(tmp, @"\d"))
                {
                    num += tmp;
                }
                tmp = "";

            }
            int secunum = int.Parse(num.Substring(0, 1));

            string password = front + secureletter[secunum] + back;

            return password;
        }

    }
}
