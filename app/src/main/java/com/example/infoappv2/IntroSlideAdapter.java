package com.example.infoappv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public class IntroSlideAdapter extends RecyclerView {
        private List introSlides;

        @Override
        onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
                Intrinsics.checkParameterIsNotNull(parent, "parent");
                View var10003 = LayoutInflater.from(parent.getContext()).inflate(1300124, parent, false);
                Intrinsics.checkExpressionValueIsNotNull(var10003, "LayoutInflater.from(pare…      false\n            )");
                new IntroSlideViewHolder(var10003);
        }

        public IntroSlideAdapter(@NonNull Context context, List introSlides) {
                super(context);
                this.introSlides = introSlides;
        }

        public int getItemCount(){
                return this.introSlides.size();
        }

        public void onBindViewHolder(IntroSlideViewHolder holder, int position) {
                holder.bind(IntroSlide.get(position));
        }

        public class IntroSlideViewHolder extends RecyclerView.ViewHolder {
                private String textTitle;
                private TextView textDescription;
                private final ImageView imageIcon;

                public IntroSlideViewHolder(@NotNull View view) {
                        super(view);
                        this.textTitle = view.findViewById(R.id.textTitle);
                        this.textDescription = (TextView)view.findViewById(R.id.textDescription);
                        this.imageIcon = (ImageView)view.findViewById(R.id.imageSlideIcon);
                }

                public void bind(IntroSlide introSlide) {
                        textTitle = introSlide.title;
                        textDescription = introSlide.description;
                        imageIcon.setImageResource(introSlide.icon);
                }
        }
}