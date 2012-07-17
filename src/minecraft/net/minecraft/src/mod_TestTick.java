package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class mod_TestTick extends BaseMod {
   
   public String getVersion() {
      return "test";
   }

   public void load() {
      ModLoader.setInGUIHook(this, true, true);
   }
   
   public boolean onTickInGUI(float tick, Minecraft game, GuiScreen gui) {
      System.out.println("Testing!");
      return true;
   }
}
