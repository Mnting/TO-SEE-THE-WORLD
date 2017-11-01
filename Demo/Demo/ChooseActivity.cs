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
using static Android.Widget.RadioGroup;
using static Android.Views.View;

namespace Demo
{
    [Activity(Label = "ChooseActivity")]
    public class ChooseActivity : Activity, IOnCheckedChangeListener, IOnClickListener
    {
        private EditText year;
        private EditText month;
        private EditText day;
        private RadioGroup sexgroup;
        private RadioButton manbutton;
        private RadioButton womanbutton;
        private Button nextbutton;
        static private string sex = null;
        static private string birthdata = null;
        private Spinner cityspinner;
        static private string city = null;
        private EditText meattext;
        private EditText vegtext;
        private EditText seatext;
        public void OnCheckedChanged(RadioGroup group, int checkedId)
        {
            if (manbutton.Id == checkedId)
            {
                sex = manbutton.Text.ToString();
            }
            else if (womanbutton.Id == checkedId)
                sex = womanbutton.Text.ToString();
        }

        private void Spinner_ItemSelected(object sender, AdapterView.ItemSelectedEventArgs e)
        {
            Spinner spinner = (Spinner)sender;

            city = string.Format("Your city is {0}", spinner.GetItemAtPosition(e.Position));
            Toast.MakeText(this, city, ToastLength.Long).Show();
        }

        public void OnClick(View v)
        {
            if (v.Id == Resource.Id.nextbutton)
            {
                year = FindViewById<EditText>(Resource.Id.year);
                month = FindViewById<EditText>(Resource.Id.month);
                day = FindViewById<EditText>(Resource.Id.day);
                birthdata += year.Text + month.Text + day.Text;

                if (city.Length == 0 || birthdata.Length == 0)
                {
                    Toast.MakeText(this, "请确保信息全部填写！", ToastLength.Long).Show();
                }
                else
                {
                    ISharedPreferences mySharedPreferences = GetSharedPreferences("information", FileCreationMode.Private);
                    //实例化SharedPreferences.Editor对象（第二步）   
                    ISharedPreferencesEditor editor = mySharedPreferences.Edit();
                    //用putString的方法保存数据   
                    editor.PutString("sex", sex);
                    editor.PutString("birth", birthdata);
                    editor.PutString("city", city);
                    //提交当前数据   
                    editor.Commit();
                    SetContentView(Resource.Layout.Donteat);
                    Button finishbutton = FindViewById<Button>(Resource.Id.finishbutton);
                    finishbutton.SetOnClickListener(this);
                }
            }
            else if (v.Id == Resource.Id.finishbutton)
            {
                meattext = FindViewById<EditText>(Resource.Id.textmeat);
                vegtext = FindViewById<EditText>(Resource.Id.textveg);
                seatext = FindViewById<EditText>(Resource.Id.textsea);

                if (!(meattext.Length() == 0 || vegtext.Length() == 0 || seatext.Length() == 0))
                {
                    ISharedPreferences
                          mySharedPreferences = GetSharedPreferences("information", FileCreationMode.Append);
                    //实例化SharedPreferences.Editor对象（第二步）   
                    ISharedPreferencesEditor editor = mySharedPreferences.Edit();
                    //用putString的方法保存数据   
                    if (!(meattext.Length() == 0))
                    {
                        editor.PutString("meat", meattext.Text.ToString());
                    }
                    if (!(vegtext.Length() == 0))
                    {
                        editor.PutString("veg", vegtext.Text.ToString());
                    }
                    if (!(seatext.Length() == 0))
                    {
                        editor.PutString("sea", seatext.Text.ToString());
                    }
                    //提交当前数据   
                    editor.Commit();
                }
                Intent intent = new Intent(this, typeof(EndActivity));
                StartActivity(intent);
                Finish();

            }
        }

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.Choose);
            // Create your application here
            nextbutton = FindViewById<Button>(Resource.Id.nextbutton);

            sexgroup = FindViewById<RadioGroup>(Resource.Id.sexGroup);
            manbutton = FindViewById<RadioButton>(Resource.Id.manbutton);
            womanbutton = FindViewById<RadioButton>(Resource.Id.womanbutton);
            sexgroup.SetOnCheckedChangeListener(this);




            cityspinner = FindViewById<Spinner>(Resource.Id.citylist);

            cityspinner.ItemSelected += new EventHandler<AdapterView.ItemSelectedEventArgs>(Spinner_ItemSelected);
            var adapter = ArrayAdapter.CreateFromResource(
                    this, Resource.Array.city_array, Android.Resource.Layout.SimpleSpinnerItem);

            adapter.SetDropDownViewResource(Android.Resource.Layout.SimpleSpinnerDropDownItem);
            cityspinner.Adapter = adapter;


            nextbutton.SetOnClickListener(this);

        }

    }
}