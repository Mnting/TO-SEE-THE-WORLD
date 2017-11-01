using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using static Android.Views.View;

namespace Demo
{
    [Activity(Label = "LoginActivity")]
    public class LoginActivity : Activity, IOnClickListener
    {

        private EditText numText;
        private EditText pswText;
        private Button loginbutton;
        private Button registerbutton;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.Login);
            // Create your application here


            loginbutton = FindViewById<Button>(Resource.Id.loginenter);
            registerbutton = FindViewById<Button>(Resource.Id.register);
            registerbutton.SetOnClickListener(this);
            loginbutton.SetOnClickListener(this);

        }

        public void OnClick(View v)
        {
            if (v.Id == Resource.Id.ok)
            {
                numText = FindViewById<EditText>(Resource.Id.getnumber);
                pswText = FindViewById<EditText>(Resource.Id.getpassword);
                if (numText.Length() == 0 || pswText.Length() == 0)
                {
                    Toast.MakeText(this, "账号密码不得为空！", ToastLength.Long).Show();
                }
                else
                {

                    ISharedPreferences mySharedPreferences = GetSharedPreferences("test", FileCreationMode.Append);
                    //实例化SharedPreferences.Editor对象（第二步）   
                    ISharedPreferencesEditor editor = mySharedPreferences.Edit();
                    //用putString的方法保存数据   
                    editor.PutString("nub", numText.Text.ToString());
                    editor.PutString("psw", pswText.Text.ToString());
                    //提交当前数据   
                    editor.Commit();
                    Toast.MakeText(this, "注册成功！", ToastLength.Long).Show();
                    Intent intent = new Intent(this, typeof(LoginActivity));
                    StartActivity(intent);
                    Finish();
                }
            }
            else if (v.Id == Resource.Id.register)
            {
                SetContentView(Resource.Layout.Registerlayout);
                Button okbutton = FindViewById<Button>(Resource.Id.ok);
                okbutton.SetOnClickListener(this);
            }
            else if (v.Id == Resource.Id.loginenter)
            {
                numText = FindViewById<EditText>(Resource.Id.number);
                pswText = FindViewById<EditText>(Resource.Id.password);

                if ((numText.Text.Equals("20155355")) && (pswText.Text.Equals("123456")))
                {
                    Intent intent = new Intent(this, typeof(ChooseActivity));
                    StartActivity(intent);
                    Finish();
                    Toast.MakeText(this, "登录成功！", ToastLength.Long).Show();
                }

                else
                {
                    ISharedPreferences mySharedPreferences = GetSharedPreferences("test", FileCreationMode.Private);
                    //实例化SharedPreferences.Editor对象（第二步）   
                    if ((numText.Text.Equals(mySharedPreferences.GetString("nub", "")))
                        && (pswText.Text.Equals(mySharedPreferences.GetString("psw", ""))))
                    {
                        Intent intent = new Intent(this, typeof(ChooseActivity));
                        StartActivity(intent);
                        Finish();
                        Toast.MakeText(this, "登录成功！", ToastLength.Long).Show();
                    }

                }
            }
        }
    }
}