package ru.job4j.search;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 27.03.2018
 * @version 1
 */
public class Task {
        private String desc;
        private int priority;

        public Task(String desc, int priority) {
            this.desc = desc;
            this.priority = priority;
        }

        public String getDesc() {
            return desc;
        }

        public int getPriority() {
            return priority;
        }
}
