using Android.App;
using Android.OS;
using Android.Views;
using Android.Widget;
namespace Demo
{
    public class FragmentContent : Fragment
    {
        private string _text;
        public FragmentContent(string text)
        {
            _text = text;
        }
        public override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
        }

        public override View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            //get the view
            View view = inflater.Inflate(Resource.Layout.fragmentcontent, null);
            var txt = view.FindViewById<TextView>(Resource.Id.txtName);
            //set the text of the textview
            txt.Text = "I Love " + _text;
            return view;
        }
    }
}