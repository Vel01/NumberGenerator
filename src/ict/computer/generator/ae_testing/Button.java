package ict.computer.generator.ae_testing;

final class Button {

    private final String name;
    private OnClickedListener onClickedListener;

    private Button(String name) {
        this.name = name;
    }

    public int onClicked() {
        return this.onClickedListener.onClicked();
    }

    public void setOnClickedListener(OnClickedListener onClickedListener) {
        this.onClickedListener = onClickedListener;
    }

    public interface OnClickedListener {
        int onClicked();
    }

    public String getName() {
        return name;
    }

    public static Button create(String name) {
        return new Button(name);
    }
}
