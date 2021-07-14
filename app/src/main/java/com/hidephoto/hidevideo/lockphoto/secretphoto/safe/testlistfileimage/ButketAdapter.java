package com.hidephoto.hidevideo.lockphoto.secretphoto.safe.testlistfileimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class ButketAdapter extends RecyclerView.Adapter<ButketAdapter.ButketViewHolder>{
    private Context mContext;
    private List<Butket> mListButket;

    public ButketAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Butket> list){
        this.mListButket=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ButketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_butket,parent,false);
        return new ButketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButketAdapter.ButketViewHolder holder, int position) {
        Butket butket= mListButket.get(position);
        if (mListButket==null){
            return;
        }
        holder.path.setText(butket.getFirstImageContainedPath());
        holder.fileName.setText(butket.getName());
        File imgFile = new  File(butket.getFirstImageContainedPath());
        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            //Drawable d = new BitmapDrawable(getResources(), myBitmap);
            holder.imageFile.setImageBitmap(myBitmap);

        }

    }

    @Override
    public int getItemCount() {
        if (mListButket!=null){
            return mListButket.size();
        }
        return 0;
    }

    public class ButketViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageFile;
        private TextView fileName, path;
        public ButketViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFile=itemView.findViewById(R.id.imageFile);
            fileName=itemView.findViewById(R.id.fileName);
            path=itemView.findViewById(R.id.path);
        }
    }
}
