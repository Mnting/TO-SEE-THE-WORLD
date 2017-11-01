using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace C____0007
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void userinformationBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.userinformationBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this._C_textDataSet);

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: 这行代码将数据加载到表“_C_textDataSet.userinformation”中。您可以根据需要移动或删除它。
            this.userinformationTableAdapter.Fill(this._C_textDataSet.userinformation);

        }
    }
}
