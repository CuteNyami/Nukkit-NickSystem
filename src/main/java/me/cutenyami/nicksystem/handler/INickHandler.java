package me.cutenyami.nicksystem.handler;

public interface INickHandler {

    void createUser();

    void updateNick(String name);

    void resetNick();

    boolean existsPlayer();

    String getName();

}
