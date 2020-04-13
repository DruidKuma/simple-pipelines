package com.druidkuma.pipelines.descriptor;

import java.util.List;

/**
 * Created by Yurii Miedviediev
 *
 * @author DruidKuma
 * @version 1.0.0
 * @since 13.04.2020
 */
public class PipelineDescriptor {
    private List<PipelineStep> steps;

    private PipelineDescriptor() {
    }

    public PipelineDescriptor(List<PipelineStep> steps) {
        this.steps = steps;
    }

    public List<PipelineStep> getSteps() {
        return steps;
    }

    public void setSteps(List<PipelineStep> steps) {
        this.steps = steps;
    }
}
