package top.young.util;

import java.util.Arrays;  

import javax.swing.UIDefaults;  
import javax.swing.plaf.ColorUIResource;  
import javax.swing.plaf.metal.OceanTheme;  
  
public class Mytheme extends OceanTheme {  
    @Override  
    public void addCustomEntriesToTable(UIDefaults table) {  
        super.addCustomEntriesToTable(table);  
        ColorUIResource plainColor = new ColorUIResource(0xDDE8F3);  
        java.util.List<Object> buttonGradient = Arrays.asList(new Object[] {  
                .5f, 0f, plainColor, plainColor, plainColor });  
        table.put("Button.gradient", buttonGradient);  
    }  
}  
