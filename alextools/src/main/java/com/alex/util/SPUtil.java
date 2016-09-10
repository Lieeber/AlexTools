package com.alex.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * 作者：Alex
 * 时间：2016年09月03日    10:12
 * 简述：
 */

@SuppressWarnings("all")
public class SPUtil
{
    private static String FILE_NAME = "DefaultSharedPreferences";
    public static void spName(String name){
        SPUtil.FILE_NAME = name;
    }
    private static SharedPreferences sp(){
        if(BaseUtil.isAppNull()){
            return null;
        }
        SharedPreferences sharedPreferences = BaseUtil.app().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences;
    }
    /**存入String数据
     * <br/>失败, 返回false
     * @param key 键, !null, !""
     * @param value 值
     */
    public static boolean putString(String key, String value)
    {
        if(TextUtils.isEmpty(key) || TextUtils.isEmpty(value)){
            return false;
        }
        SharedPreferences settings = sp();
        if(settings == null){
            return false;
        }
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**取出String, 失败, 返回null
     * @param key 键, !null, !""
     */
    public static String getString(Context context, String key) {
        if(TextUtils.isEmpty(key)){
            return null;
        }
        return getString(context, key, null);
    }

    /**取出String, 失败, 返回 defaultValue
     * @param key 键, !null, !""*/
    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences settings = sp();
        if(settings == null){
            return null;
        }
        return settings.getString(key, defaultValue);
    }

    /**存入int, 失败, 返回, false
     * @param key 键, !null, !""
     */
    public static boolean putInt(Context context, String key, int value) {
        if(TextUtils.isEmpty(key)){
            return false;
        }
        SharedPreferences settings = sp();
        if(settings == null){
            return false;
        }
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }
    /**取出int,  失败, 返回,  -2^31
     * @param key 键, !null, !""
     */
    public static int getInt(Context context, String key) {
        if(TextUtils.isEmpty(key)){
            return Integer.MIN_VALUE;
        }
        return getInt(context, key, -1);
    }
    /**取出int,  失败, 返回,  defaultValue
     * @param key 键, !null, !""
     */
    public static int getInt(Context context, String key, int defaultValue) {
        if(TextUtils.isEmpty(key)){
            return defaultValue;
        }
        SharedPreferences settings = sp();
        if(settings == null){
            return defaultValue;
        }
        return settings.getInt(key, defaultValue);
    }
    /**存入long,  失败, 返回,  false
     * @param key 键, !null, !""
     */
    public static boolean putLong(Context context, String key, long value) {
        if(TextUtils.isEmpty(key)){
            return false;
        }
        SharedPreferences settings = sp();
        if(settings == null){
            return false;
        }
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }
    /**取出long,  失败, 返回,   - 2^63
     * @param key 键, !null, !""
     */
    public static long getLong(Context context, String key) {
        if(TextUtils.isEmpty(key)){
            return Long.MIN_VALUE;
        }
        return getLong(context, key, Long.MIN_VALUE);
    }
    /**取出long,  失败, 返回,   defaultValue
     * @param key 键, !null, !""
     */
    public static long getLong(Context context, String key, long defaultValue) {
        if(TextUtils.isEmpty(key)){
            return defaultValue;
        }
        SharedPreferences settings = sp();
        if(settings == null){
            return defaultValue;
        }
        return settings.getLong(key, defaultValue);
    }
    /**存入float,  失败, 返回,  false
     * @param key 键, !null, !""
     */
    public static boolean putFloat(Context context, String key, float value) {
        if(TextUtils.isEmpty(key)){
            return false;
        }
        SharedPreferences settings = sp();
        if(settings == null){
            return false;
        }
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }
    /**取出float,  失败, 返回,   2^-149
     * @param key 键, !null, !""
     */
    public static float getFloat(Context context, String key) {
        if(TextUtils.isEmpty(key)){
            return Float.MIN_VALUE;
        }
        return getFloat(context, key, Float.MIN_VALUE);
    }
    /**取出float,  失败, 返回,   defaultValue
     * @param key 键, !null, !""
     */
    public static float getFloat(Context context, String key, float defaultValue) {
        if(TextUtils.isEmpty(key)){
            return defaultValue;
        }
        SharedPreferences settings = sp();
        if(settings == null){
            return defaultValue;
        }
        return settings.getFloat(key, defaultValue);
    }
    /**存入boolean,  失败, 返回,  false
     * @param key 键, !null, !""
     */
    public static boolean putBoolean(Context context, String key, boolean value) {
        if(TextUtils.isEmpty(key)){
            return false;
        }
        SharedPreferences settings = sp();
        if(settings == null){
            return false;
        }
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }
    /**取出boolean,  失败, 返回,   false
     * @param key 键, !null, !""
     */
    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);
    }
    /**取出boolean,  失败, 返回,   defaultValue
     * @param key 键, !null, !""
     */
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        if(TextUtils.isEmpty(key)){
            return defaultValue;
        }
        SharedPreferences settings = sp();
        if(settings == null){
            return defaultValue;
        }
        return settings.getBoolean(key, defaultValue);
    }
    /**移除键值对, 失败, 返回false
     * @param key 键, !null, !""
     */
    public static boolean removeString(Context context, String key){
        if(TextUtils.isEmpty(key)){
            return false;
        }
        SharedPreferences settings = sp();
        if(settings == null){
            return false;
        }
        SharedPreferences.Editor editor = settings.edit();
        return editor.remove(key).commit();
    }

}

