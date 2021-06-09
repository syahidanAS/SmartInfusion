package com.example.smartinfusion.controller;

public class Dataku {
    String kunci;
    String ruangan;
    int status_1;
    int status_2;
    int calibration_1;
    int calibration_2;
    long curtime_1;
    long curtime_2;
    int infusion_volume_1, infusion_volume_2;
    int drops_rate_1, drops_rate_2;
    int urine_volume_1, urine_volume_2;
    int restore_hour_1, restore_hour_2, restore_minute_1, restore_minute_2;
    int infusion_alarm_1, infusion_alarm_2, urine_alarm_1, urine_alarm_2;

    public Dataku() {
    }

    public Dataku(String kunci, String ruangan, int status_1, int status_2, int calibration_1, int calibration_2, long curtime_1, long curtime_2, int infusion_volume_1, int infusion_volume_2, int drops_rate_1, int drops_rate_2, int urine_volume_1, int urine_volume_2, int restore_hour_1, int restore_hour_2, int restore_minute_1, int restore_minute_2, int infusion_alarm_1, int infusion_alarm_2, int urine_alarm_1, int urine_alarm_2) {
        this.kunci = kunci;
        this.ruangan = ruangan;
        this.status_1 = status_1;
        this.status_2 = status_2;
        this.calibration_1 = calibration_1;
        this.calibration_2 = calibration_2;
        this.curtime_1 = curtime_1;
        this.curtime_2 = curtime_2;
        this.infusion_volume_1 = infusion_volume_1;
        this.infusion_volume_2 = infusion_volume_2;
        this.drops_rate_1 = drops_rate_1;
        this.drops_rate_2 = drops_rate_2;
        this.urine_volume_1 = urine_volume_1;
        this.urine_volume_2 = urine_volume_2;
        this.restore_hour_1 = restore_hour_1;
        this.restore_hour_2 = restore_hour_2;
        this.restore_minute_1 = restore_minute_1;
        this.restore_minute_2 = restore_minute_2;
        this.infusion_alarm_1 = infusion_alarm_1;
        this.infusion_alarm_2 = infusion_alarm_2;
        this.urine_alarm_1 = urine_alarm_1;
        this.urine_alarm_2 = urine_alarm_2;
    }

    public String getKunci() {
        return kunci;
    }

    public void setKunci(String kunci) {
        this.kunci = kunci;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public int getStatus_1() {
        return status_1;
    }

    public void setStatus_1(int status_1) {
        this.status_1 = status_1;
    }

    public int getStatus_2() {
        return status_2;
    }

    public void setStatus_2(int status_2) {
        this.status_2 = status_2;
    }

    public int getCalibration_1() {
        return calibration_1;
    }

    public void setCalibration_1(int calibration_1) {
        this.calibration_1 = calibration_1;
    }

    public int getCalibration_2() {
        return calibration_2;
    }

    public void setCalibration_2(int calibration_2) {
        this.calibration_2 = calibration_2;
    }

    public long getCurtime_1() {
        return curtime_1;
    }

    public void setCurtime_1(long curtime_1) {
        this.curtime_1 = curtime_1;
    }

    public long getCurtime_2() {
        return curtime_2;
    }

    public void setCurtime_2(long curtime_2) {
        this.curtime_2 = curtime_2;
    }

    public int getInfusion_volume_1() {
        return infusion_volume_1;
    }

    public void setInfusion_volume_1(int infusion_volume_1) {
        this.infusion_volume_1 = infusion_volume_1;
    }

    public int getInfusion_volume_2() {
        return infusion_volume_2;
    }

    public void setInfusion_volume_2(int infusion_volume_2) {
        this.infusion_volume_2 = infusion_volume_2;
    }

    public int getDrops_rate_1() {
        return drops_rate_1;
    }

    public void setDrops_rate_1(int drops_rate_1) {
        this.drops_rate_1 = drops_rate_1;
    }

    public int getDrops_rate_2() {
        return drops_rate_2;
    }

    public void setDrops_rate_2(int drops_rate_2) {
        this.drops_rate_2 = drops_rate_2;
    }

    public int getUrine_volume_1() {
        return urine_volume_1;
    }

    public void setUrine_volume_1(int urine_volume_1) {
        this.urine_volume_1 = urine_volume_1;
    }

    public int getUrine_volume_2() {
        return urine_volume_2;
    }

    public void setUrine_volume_2(int urine_volume_2) {
        this.urine_volume_2 = urine_volume_2;
    }

    public int getRestore_hour_1() {
        return restore_hour_1;
    }

    public void setRestore_hour_1(int restore_hour_1) {
        this.restore_hour_1 = restore_hour_1;
    }

    public int getRestore_hour_2() {
        return restore_hour_2;
    }

    public void setRestore_hour_2(int restore_hour_2) {
        this.restore_hour_2 = restore_hour_2;
    }

    public int getRestore_minute_1() {
        return restore_minute_1;
    }

    public void setRestore_minute_1(int restore_minute_1) {
        this.restore_minute_1 = restore_minute_1;
    }

    public int getRestore_minute_2() {
        return restore_minute_2;
    }

    public void setRestore_minute_2(int restore_minute_2) {
        this.restore_minute_2 = restore_minute_2;
    }

    public int getInfusion_alarm_1() {
        return infusion_alarm_1;
    }

    public void setInfusion_alarm_1(int infusion_alarm_1) {
        this.infusion_alarm_1 = infusion_alarm_1;
    }

    public int getInfusion_alarm_2() {
        return infusion_alarm_2;
    }

    public void setInfusion_alarm_2(int infusion_alarm_2) {
        this.infusion_alarm_2 = infusion_alarm_2;
    }

    public int getUrine_alarm_1() {
        return urine_alarm_1;
    }

    public void setUrine_alarm_1(int urine_alarm_1) {
        this.urine_alarm_1 = urine_alarm_1;
    }

    public int getUrine_alarm_2() {
        return urine_alarm_2;
    }

    public void setUrine_alarm_2(int urine_alarm_2) {
        this.urine_alarm_2 = urine_alarm_2;
    }
}