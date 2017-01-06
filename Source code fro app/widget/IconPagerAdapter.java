package com.exam2.widget;

public interface IconPagerAdapter {
    /**
     * Get icon representing the page.
     */
    int getIconResId(int index);

    // From PagerAdapter
    int getCount();
}
