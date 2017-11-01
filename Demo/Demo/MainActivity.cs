using Android.App;
using Android.Widget;
using Android.OS;
using Android.Views;
using Android.Content;
using static Android.Views.View;
using Android.Support.V4.Widget;
using Android.Graphics;

namespace Demo
{
    [Activity(Label = "Demo")]
    public class MainActivity : Activity, IOnClickListener
    {
        private string[] menu;//侧拉菜单
        private Button enterbutton;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);
            enterbutton = FindViewById<Button>(Resource.Id.sloganenter);
            enterbutton.SetOnClickListener(this);
        

        menu = new string[] { "我的资料", "聚会食谱", "出去吃吧" };
            //listview
            var listView = FindViewById<ListView>(Resource.Id.left_drawer);
            //adapter
            listView.Adapter = new ArrayAdapter<string>
                (this, Android.Resource.Layout.SimpleListItem1, menu);
            //drawerlayout
             var drawerLayout = FindViewById<DrawerLayout>(Resource.Id.drawer_layout);
            //click event
            drawerLayout.SetScrimColor(Color.Transparent);
            listView.ItemClick += ItemClick;
         }
        private void ItemClick(object sender, AdapterView.ItemClickEventArgs e)
        {  
                 Fragment fragment = new FragmentContent(menu[e.Position]);
                 var fm = FragmentManager.BeginTransaction().Replace
                          (Resource.Id.content_frame, fragment).Commit();
           }



        public void OnClick(View v)
        {
            Intent intent = new Intent(this, typeof(LoginActivity));
            StartActivity(intent);
            Finish();
        }
    }
}