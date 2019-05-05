package ru.job4j.lsp;

import java.util.List;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 06.05.2019
 */
public interface Strategy {

    boolean execute(Food food);

    List getList();

}
