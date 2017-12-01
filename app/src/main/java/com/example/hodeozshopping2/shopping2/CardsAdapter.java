package com.example.hodeozshopping2.shopping2;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CardsAdapter extends BaseAdapter {

    private Activity activity;
    private final static int AVATAR_WIDTH = 150;
    private final static int AVATAR_HEIGHT = 300;
    private final static int TOQUE_WIDTH = 28;
    private final static int TOQUE_HEIGHT = 30;
    private List<CardItem> data;

    public CardsAdapter(Activity activity, List<CardItem> data) {
        this.data = data;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CardItem getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_card, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        //setting data to views
        holder.name.setText(getItem(position).getName());
        holder.location.setText(getItem(position).getLocation());
        holder.avatar.setImageBitmap(decodeSampledBitmapFromResource(activity.getResources(),
                getItem(position).getDrawableId(), AVATAR_WIDTH, AVATAR_HEIGHT));
   /*     holder.toque1.setImageBitmap(decodeSampledBitmapFromResource(activity.getResources(),
                getItem(position).getDifficulteIdun(), TOQUE_WIDTH, TOQUE_HEIGHT));
        holder.toque2.setImageBitmap(decodeSampledBitmapFromResource(activity.getResources(),
                getItem(position).getDifficulteIddeux(), TOQUE_WIDTH, TOQUE_HEIGHT));
        holder.toque3.setImageBitmap(decodeSampledBitmapFromResource(activity.getResources(),
                getItem(position).getDifficulteIdtrois(), TOQUE_WIDTH, TOQUE_HEIGHT));
        holder.toque4.setImageBitmap(decodeSampledBitmapFromResource(activity.getResources(),
                getItem(position).getDifficulteIdquatre(), TOQUE_WIDTH, TOQUE_HEIGHT));
        holder.toque5.setImageBitmap(decodeSampledBitmapFromResource(activity.getResources(),
                getItem(position).getDifficulteIdcinq(), TOQUE_WIDTH, TOQUE_HEIGHT));
*/
        holder.toque1.setImageResource(getItem(position).getDifficulteIdun());
        holder.toque2.setImageResource(getItem(position).getDifficulteIddeux());
        holder.toque3.setImageResource(getItem(position).getDifficulteIdtrois());
        holder.toque4.setImageResource(getItem(position).getDifficulteIdquatre());
        holder.toque5.setImageResource(getItem(position).getDifficulteIdcinq());

        return convertView;
    }

    private class ViewHolder {
        private ImageView avatar;
        private TextView name;
        private TextView location;
        private ImageView toque1;
        private ImageView toque2;
        private ImageView toque3;
        private ImageView toque4;
        private ImageView toque5;


        public ViewHolder(View view) {
            avatar = (ImageView) view.findViewById(R.id.avatar);
            name = (TextView) view.findViewById(R.id.name);
            location = (TextView) view.findViewById(R.id.location);
            toque1 = (ImageView) view.findViewById(R.id.toque1);
            toque2 = (ImageView) view.findViewById(R.id.toque2);
            toque3 = (ImageView) view.findViewById(R.id.toque3);
            toque4 = (ImageView) view.findViewById(R.id.toque4);
            toque5 = (ImageView) view.findViewById(R.id.toque5);
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

}
