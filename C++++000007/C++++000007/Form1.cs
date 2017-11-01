using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace C____000007
{
    public partial class Form1 : Form
    {

        private string id = null, name = null, sex = null, clas = null;
        public Form1()
        {
            InitializeComponent();     
            dataGridView1.CellEndEdit += dataGridView1_CellEndEdit;
            
        }

        private void delete_Click(object sender, EventArgs e)
        {
            int i = this.dataGridView1.SelectedRows.Count;
            id = dataGridView1.SelectedRows[i - 1].Cells[0].Value.ToString();
            dataGridView1.Rows.RemoveAt(dataGridView1.SelectedRows[i - 1].Index);
            SqlConnection sqlConnection = new SqlConnection();
            sqlConnection.ConnectionString =
                @"Data Source=.;Initial Catalog=C#text;Integrated Security=True";

            SqlCommand sqlCommand = new SqlCommand();
            sqlCommand.CommandText =
                "delete from userinformation where id='" +id+ "'";
            sqlCommand.Connection = sqlConnection;
            sqlConnection.Open();
            sqlCommand.ExecuteNonQuery();
            sqlConnection.Close();
            MessageBox.Show("删除成功");
        }

        private void change_Click(object sender, EventArgs e)
        {
            int i = this.dataGridView1.SelectedRows.Count;
            id = dataGridView1.SelectedRows[i - 1].Cells[0].Value.ToString();
            name = dataGridView1.SelectedRows[i - 1].Cells[1].Value.ToString();
            sex = dataGridView1.SelectedRows[i - 1].Cells[2].Value.ToString();
            clas = dataGridView1.SelectedRows[i - 1].Cells[3].Value.ToString();
            SqlConnection sqlConnection = new SqlConnection();
            sqlConnection.ConnectionString =
                @"Data Source=.;Initial Catalog=C#text;Integrated Security=True";

            SqlCommand sqlCommand = new SqlCommand();
            sqlCommand.CommandText =
                "update  userinformation set  name=" + name + ",sex=" + sex + ",clas=" + clas + " where id="+id+"";
            sqlCommand.Connection = sqlConnection;
            sqlConnection.Open();
            sqlCommand.ExecuteNonQuery();
            sqlConnection.Close();
            MessageBox.Show("修改成功");
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: 这行代码将数据加载到表“_C_textDataSet1.userinformation”中。您可以根据需要移动或删除它。
            this.userinformationTableAdapter1.Fill(this._C_textDataSet1.userinformation);
            
        }

        private void dataGridView1_CellEndEdit(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView1.Rows.Count > 0)
            {
                id = dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString();
                name = dataGridView1.Rows[e.RowIndex].Cells[1].Value.ToString();
                sex = dataGridView1.Rows[e.RowIndex].Cells[2].Value.ToString();
                clas = dataGridView1.Rows[e.RowIndex].Cells[3].Value.ToString();               
            }
        }

        private void add_Click(object sender, EventArgs e)
        {
            SqlConnection sqlConnection = new SqlConnection();
            sqlConnection.ConnectionString =
                @"Data Source=.;Initial Catalog=C#text;Integrated Security=True";

            SqlCommand sqlCommand = new SqlCommand();
            sqlCommand.CommandText =
                "insert into  userinformation values( "+id+","+name+","+sex+","+clas+")";
            sqlCommand.Connection = sqlConnection;
            sqlConnection.Open();
            sqlCommand.ExecuteNonQuery();
            sqlConnection.Close();
            MessageBox.Show("添加成功");
        }
    }
}
