package com.krypto.blocks.particletextview.MovingStrategy.Object;

import android.util.Log;

import com.krypto.blocks.particletextview.MovingStrategy.MovingStrategy.MovingStrategy;
import com.krypto.blocks.particletextview.MovingStrategy.MovingStrategy.RandomMovingStrategy;

public class ParticleTextViewConfig {
    private int columnStep = 3;
    private int rowStep = 3;
    private double releasing = 0.1;
    private double miniJudgeDistance = 0.05;
    private String targetText = "Default";
    private String[] targetTextArray;
    private int textSize = 120;
    private float particleRadius = 1;
    private String[] particleColorArray = null;
    private MovingStrategy movingStrategy = new RandomMovingStrategy();
    private long delay = 1000;

    private ParticleTextViewConfig(){}

    public static class Builder {
        private ParticleTextViewConfig particleTextViewConfig = null;
        public Builder(){
            this.particleTextViewConfig = new ParticleTextViewConfig();
        }

        public Builder setColumnStep(int columnStep){
            if (columnStep < 0){
                columnStep = 0;
            }
            particleTextViewConfig.columnStep = columnStep;
            return this;
        }

        public Builder setRowStep(int rowStep){
            if (rowStep < 0){
                rowStep = 0;
            }
            particleTextViewConfig.rowStep = rowStep;
            return this;
        }

        public Builder setReleasing(double releasing) {
            if (releasing < 0){
                releasing = 0;
            }
            particleTextViewConfig.releasing = releasing;
            return this;
        }

        public Builder setMiniDistance(double miniDistance) {
            if (miniDistance < 0){
                miniDistance = 0;
            }
            particleTextViewConfig.miniJudgeDistance = miniDistance;
            return this;
        }

        public Builder setTargetText(String targetText) {
            particleTextViewConfig.targetText = targetText;
            return this;
        }

        public Builder setTargetText(String[] targetTextArray) {
            particleTextViewConfig.targetTextArray = targetTextArray;
            return this;
        }

        public Builder setTextSize(int textSize) {
            particleTextViewConfig.textSize = textSize;
            return this;
        }

        public Builder setParticleRadius(float radius){
            if (radius < 0){
                Log.e("ConfigWarning", "Particle radius should not be negative");
            }
            particleTextViewConfig.particleRadius = radius;
            return this;
        }

        public Builder setParticleColorArray(String[] particleColorArray){
            if (particleColorArray == null || particleColorArray.length == 0){
                Log.e("ConfigError", "The length of particleColorArray must bigger than 0!Has set it to random color array");
                particleColorArray = null;
            }
            particleTextViewConfig.particleColorArray = particleColorArray;
            return this;
        }

        public Builder setMovingStrategy(MovingStrategy movingStrategy){
            if (movingStrategy == null){
                Log.e("ConfigError", "Moving strategy cannot be null!Has set it to RandomMovingStrategy");
                movingStrategy = new RandomMovingStrategy();
            }
            particleTextViewConfig.movingStrategy = movingStrategy;
            return this;
        }

        public Builder setDelay(Long delay){
            if (delay < (long)-1){
                delay = (long)-1;
            }
            particleTextViewConfig.delay = delay;
            return this;
        }

        public ParticleTextViewConfig instance(){
            return particleTextViewConfig;
        }
    }

    public int getColumnStep() {
        return columnStep;
    }

    public int getRowStep() {
        return rowStep;
    }

    public double getReleasing() {
        return releasing;
    }

    public double getMiniJudgeDistance() {
        return miniJudgeDistance;
    }

    public String getTargetText() {
        return targetText;
    }

    public String[] getTargetTextArray() {
        return targetTextArray;
    }

    public int getTextSize() {
        return textSize;
    }

    public float getParticleRadius() {
        return particleRadius;
    }

    public String[] getParticleColorArray() {
        return particleColorArray;
    }

    public MovingStrategy getMovingStrategy() {
        return movingStrategy;
    }

    public long getDelay() {
        return delay;
    }
}
