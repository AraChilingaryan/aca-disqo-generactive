package com.aca_disqo_generactive.utils;

public enum Resolution {
    HD,
    FHD,
    _4K;

    public static int getResolutionValue(Resolution resolution){
        if(resolution == Resolution._4K){
            return 4;
        }if(resolution == Resolution.FHD){
            return 2;
        }if(resolution == Resolution.HD){
            return 1;
        }
        return 0;
    }
}
