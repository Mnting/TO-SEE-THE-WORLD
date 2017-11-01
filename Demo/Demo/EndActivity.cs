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
using static Android.Widget.RadioGroup;

namespace Demo
{
    [Activity(Label = "EndActivity")]
    public class EndActivity : Activity, IOnClickListener, IOnCheckedChangeListener
    {
        private RadioGroup hunsugroup;
        private RadioGroup weathergroup;
        private RadioButton yinbutton;
        private RadioButton qingbutton;
        private RadioButton yubutton;
        private RadioButton xuebutton;
        private RadioButton hunbutton;
        private RadioButton subutton;
        static private string weathernow = null;
        static private string kouwei = null;
        private ImageView iv;
        private Button buttonend;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.Endlayout);
            hunsugroup = FindViewById<RadioGroup>(Resource.Id.radioGrouphunsu);
            weathergroup = FindViewById<RadioGroup>(Resource.Id.radioGroup3);
            yinbutton = FindViewById<RadioButton>(Resource.Id.radioButtonyin);
            qingbutton = FindViewById<RadioButton>(Resource.Id.radioButtonqing);
            yubutton = FindViewById<RadioButton>(Resource.Id.radioButtonyu);
            xuebutton = FindViewById<RadioButton>(Resource.Id.radioButtonxue);
            hunbutton = FindViewById<RadioButton>(Resource.Id.radioButtonhun);
            subutton = FindViewById<RadioButton>(Resource.Id.radioButtonsu);
            weathergroup.SetOnCheckedChangeListener(this);
            hunsugroup.SetOnCheckedChangeListener(this);
            buttonend = FindViewById<Button>(Resource.Id.buttonend);
            iv = FindViewById<ImageView>(Resource.Id.imageViewcai);
            buttonend.SetOnClickListener(this);
            
        }

        public void OnClick(View v)
        {
            int num = 0;
            Random ra = new Random(unchecked((int)DateTime.Now.Ticks));
            
              if (kouwei.Equals("荤"))
              {
                   num = ra.Next(0, 3);
                   switch (num)
                   {
                       case 0: iv.SetImageResource(Resource.Drawable.jiaozi); break;
                       case 1: iv.SetImageResource(Resource.Drawable.yuxiangrousi); break;
                       case 2: iv.SetImageResource(Resource.Drawable.guobaorou); break;
                   }
              }
              else
              {
                  num = ra.Next(0, 2);
                  switch (num)
                  {
                      case 0: iv.SetImageResource(Resource.Drawable.doufu); break;
                      case 1: iv.SetImageResource(Resource.Drawable.disanxian); break;
                  }
              }

        }

        public void OnCheckedChanged(RadioGroup group, int checkedId)
        {
            if (group.Id == Resource.Id.radioGroup3)
            {
                if (yinbutton.Id == checkedId)
                {
                    weathernow = yinbutton.Text.ToString();
                }
                else if (qingbutton.Id == checkedId)
                {
                    weathernow = qingbutton.Text.ToString();
                }
                else if (yubutton.Id == checkedId)
                {
                    weathernow = yubutton.Text.ToString();
                }
                else if (xuebutton.Id == checkedId)
                {
                    weathernow = xuebutton.Text.ToString();
                }
            }
            else if (group.Id == Resource.Id.radioGrouphunsu)
            {
                if (hunbutton.Id == checkedId)
                {
                    kouwei = hunbutton.Text.ToString();
                }
                else if (subutton.Id == checkedId)
                {
                    kouwei = subutton.Text.ToString();
                }
            }

        }
    }
}