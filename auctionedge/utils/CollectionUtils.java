package com.auctionedge.utils;

import java.util.Collection;

/**
 * Utility functions for collections
 */
public class CollectionUtils {
    public static boolean isNullOrEmpty(final Collection<?> list) {
        return list == null || list.isEmpty();
    }
}