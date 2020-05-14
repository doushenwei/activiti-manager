package com.github.jackieonway.activiti.config;

import com.github.jackieonway.activiti.config.images.CustomProcessDiagramGeneratorI;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfiguration implements ProcessEngineConfigurationConfigurer {

    @Autowired
    private CustomProcessDiagramGeneratorI customProcessDiagramGeneratorI;

    @Override
    public void configure(SpringProcessEngineConfiguration processEngineConfiguration) {

        // 流程图字体
        processEngineConfiguration.setActivityFontName("宋体");
        processEngineConfiguration.setAnnotationFontName("宋体");
        processEngineConfiguration.setLabelFontName("宋体");

        processEngineConfiguration.setJpaHandleTransaction(false);
        processEngineConfiguration.setJpaCloseEntityManager(false);
        processEngineConfiguration.setJobExecutorActivate(false);
        processEngineConfiguration.setAsyncExecutorEnabled(false);

        //自定义流程图样式
        processEngineConfiguration.setProcessDiagramGenerator(customProcessDiagramGeneratorI);
    }
}
