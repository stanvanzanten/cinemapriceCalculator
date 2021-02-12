package domain.State;

public interface State {

    void create();
    void submit();
    void reserve();
    void pay();
    void cancel();
}
