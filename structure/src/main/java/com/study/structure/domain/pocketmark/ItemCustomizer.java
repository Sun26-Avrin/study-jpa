package com.study.structure.domain.pocketmark;

import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;

public class ItemCustomizer implements org.eclipse.persistence.sessions.factories.DescriptorCustomizer{

    @Override
    public void customize(ClassDescriptor descriptor) throws Exception {
        // TODO Auto-generated method stub
        descriptor.getInheritancePolicy().setShouldReadSubclasses(false);
        
    }

        
    
    
}
