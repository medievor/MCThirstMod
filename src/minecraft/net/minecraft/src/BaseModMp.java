package net.minecraft.src;

import net.minecraft.src.ThirstMod.*;
import net.minecraft.src.ThirstMod.core.ThirstUtils;

public abstract class BaseModMp extends BaseMod
{
    public BaseModMp()
    {
    }

    public final int getId()
    {
        return toString().hashCode();
    }

    public void modsLoaded()
    {
    	if(ThirstUtils.classExists("ModLoaderMp"))
    	{
    		ModLoaderMp.initialize();
    	}
        super.modsLoaded();
    }

    public void handlePacket(Packet230ModLoader packet230modloader)
    {
    }

    public void handleTileEntityPacket(int i, int j, int k, int l, int ai[], float af[], String as[])
    {
    }

    public GuiScreen handleGUI(int i)
    {
        return null;
    }
}
