package com.example.dealdaddy.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dealdaddy.Activity.AboutItemActivity;
import com.example.dealdaddy.Model.Items;
import com.example.dealdaddy.Model.ItemsWithImage;
import com.example.dealdaddy.R;
import com.squareup.picasso.Picasso;

import java.util.List;




/*
      @author - Sheetal Kumar
 */



public class RecyclerViewAdapterForItemsDetails extends RecyclerView.Adapter<RecyclerViewAdapterForItemsDetails.MyViewHolder> {

    private Context mContext;
    private List<ItemsWithImage> mData;


    public RecyclerViewAdapterForItemsDetails(Context mContext, List<ItemsWithImage> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.custom_item_layout_detail, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        holder.favImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*

                You can't get a drawable's resource id after setting this drawable as a background.
                But you can store some kind of flag or even a resource id somewhere
                outside your TextView or maybe in its tag field. In this case you'll be able to get it
                 and compare with another id.

                */

                Object tag = holder.favImageView.getTag();
                int id = R.drawable.ic_favorite_black_24dp;

                if (tag != null && ((Integer) tag).intValue() == id) {
                    id = R.drawable.ic_favorite_border_black_24dp;
                }
                holder.favImageView.setTag(id);
                holder.favImageView.setImageResource(id);



            }
        });

      //  holder.modelImage.setImageResource(mData.get(position).getProductImage());

      /*  Picasso.with(this)
                .load(menUrl)
                .into(menImageView);
*/
       // Picasso.with(mContext).load(holder.modelImage.(mData.get(position).getProductImage());

        Picasso.with(mContext).load((mData.get(position).getProductImage())).into(holder.modelImage);

        holder.companyName.setText(mData.get(position).getCompanyName());

        holder.modelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AboutItemActivity.class);
                intent.putExtra("ProductImage",mData.get(position).getProductImage());
                mContext.startActivity(intent);
                Activity activity = (Activity) mContext;
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.zoom_exit,R.anim.slide_out_right);

            }
        });



        holder.companyName.setText(mData.get(position).getCompanyName());
        holder.ItemTypeText.setText(mData.get(position).getItemType());

       // holder.modelImage.setBackground(mData.get(position).getimg());

        /* holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,Book_Activity.class);

                // passing data to the book activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);

            }
        });*/


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView priceText,companyName,ItemTypeText;
        ImageView favImageView,modelImage;

        // CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            priceText = (TextView) itemView.findViewById(R.id.textView9);
            favImageView = itemView.findViewById(R.id.imageView10);
            companyName = itemView.findViewById(R.id.textView7);
            modelImage = itemView.findViewById(R.id.imageView9);
            ItemTypeText = itemView.findViewById(R.id.textView8);

            // String text = "\\u20B9 1245  \\u20B9 2490 (50% Off)";

            // SpannableString ss = new SpannableString(text);
            // SpannableStringBuilder ssb = new SpannableStringBuilder(text);

//            ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
            //          ssb.setSpan(fcsRed, 6, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            //        priceText.setText(ssb);

            //   img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            //   cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }
}
