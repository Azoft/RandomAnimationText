package com.azoft.random;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Date: 22.12.14
 * Time: 9:29
 *
 * @author Artem Zalevskiy
 */
public class RandomEditView extends EditText {

    private final RandomTextHelper mRandomTextHelper = new RandomTextHelper();

    public RandomEditView(final Context context) {
        this(context, null);
    }

    public RandomEditView(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.randomText);
        mRandomTextHelper.init(this, typedArray);
        typedArray.recycle();
    }

    @Override
    public void setTypeface(final Typeface tf) {
        super.setTypeface(tf);
        if (null != mRandomTextHelper) {
            mRandomTextHelper.setTypeface(tf);
        }
    }

    public boolean startTextAnimation(@NonNull final String template, @NonNull final String rules) {
        return mRandomTextHelper.startTextAnimation(template, rules);
    }

    public final boolean startTextAnimation() {
        return mRandomTextHelper.startTextAnimation();
    }

    public void stopAnimation() {
        mRandomTextHelper.stopAnimation();
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!mRandomTextHelper.isFinish() && ViewGroup.LayoutParams.WRAP_CONTENT == layoutParams.width) {
            setMeasuredDimension(mRandomTextHelper.getWidthMeasureDrawText(), mRandomTextHelper.getHeightMeasureDrawText());
        }
    }

    @Override
    protected void onDraw(@NonNull final Canvas canvas) {
        if (mRandomTextHelper.isFinish()) {
            super.onDraw(canvas);
        } else {
            mRandomTextHelper.onDraw(canvas);
        }
    }

    @Override
    public Parcelable onSaveInstanceState() {
        return mRandomTextHelper.onSaveInstanceState(super.onSaveInstanceState());
    }

    @Override
    public void onRestoreInstanceState(final Parcelable state) {
        super.onRestoreInstanceState(mRandomTextHelper.onRestoreInstanceState(state));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mRandomTextHelper.resumeAnimation();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        mRandomTextHelper.pauseAnimation();
    }
}