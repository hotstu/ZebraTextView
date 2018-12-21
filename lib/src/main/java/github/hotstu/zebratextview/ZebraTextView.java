package github.hotstu.zebratextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;

/**
 * @author hglf
 * @since 2018/12/21
 */
public class ZebraTextView extends AppCompatTextView {
    private @ColorInt int evenColor;
    private @ColorInt int oddColor;
    private Rect r;

    public ZebraTextView(Context context) {
        super(context);
        init(null);
    }

    public ZebraTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ZebraTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray a = getContext().getResources().obtainAttributes(attrs, R.styleable.ZebraTextView);
        setEvenLineColor(a.getColor(R.styleable.ZebraTextView_evenLineColor, Color.TRANSPARENT));
        setOddLineColor(a.getColor(R.styleable.ZebraTextView_oddLineColor, Color.parseColor("#77E3EDCD")));
        a.recycle();
        r = new Rect();
    }

    public void setEvenLineColor(@ColorInt int color) {
        this.evenColor = color;
        postInvalidate();
    }

    public void setOddLineColor(@ColorInt int color) {
        this.oddColor = color;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Layout layout = getLayout();
        for (int i = 0; i < layout.getLineCount(); i++) {
            layout.getLineBounds(i, r);
            getPaint().setColor(i % 2 == 0 ? oddColor : evenColor);
            r.left = getPaddingLeft();
            r.right = getMeasuredWidth() - getPaddingRight();
            canvas.drawRect(r, getPaint());
        }
        super.onDraw(canvas);
    }
}
