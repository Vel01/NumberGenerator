package ict.computer.generator.ad_testing;

final class Button {

    private final String name;
    private OnClickedListener onClickedListener;

    private Button(String name) {
        this.name = name;
    }

    public String onClicked(){
        return this.onClickedListener.onClicked();
    }

    public void setOnClickedListener (OnClickedListener onClickedListener){
        this.onClickedListener = onClickedListener;
    }

    public interface OnClickedListener {
        String onClicked();
    }

    public String getName() {
        return name;
    }

    public static Button create(String name){
        return new Button(name);
    }
}
