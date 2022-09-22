package com.example.opengl3renderer.ui.object2d;

import android.content.Context;

import com.example.opengl3renderer.math.Mat4;
import com.example.opengl3renderer.renderer.Shader;
import com.example.opengl3renderer.renderer.Uniform;

public class Object2DShader extends Shader {
    protected Uniform model;
    protected Uniform aspectRatio;
    public Object2DShader(String vertexShaderSource, String fragmentShaderSource){
        super(vertexShaderSource, fragmentShaderSource);
        model = new Uniform("uModel", shaderProgramId);
        aspectRatio = new Uniform("uAspectRatio", shaderProgramId);
    }

    public Object2DShader(Context context, String vertexShaderPath, String fragmentShaderPath){
        super(context, vertexShaderPath, fragmentShaderPath);
        model = new Uniform("uModel", shaderProgramId);
        aspectRatio = new Uniform("uAspectRatio", shaderProgramId);
    }

    public void setModel(Mat4 model){
        this.model.setObject(model);
        this.model.sendToShader();
    }

    public void setAspectRatio(float aspectRatio){
        this.aspectRatio.setObject(aspectRatio);
        this.aspectRatio.sendToShader();
    }
}
