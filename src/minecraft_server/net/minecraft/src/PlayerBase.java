package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public abstract class PlayerBase
{
    protected final EntityPlayerMP player;
    private final PlayerAPI playerAPI;

    public PlayerBase(PlayerAPI playerapi)
    {
        playerAPI = playerapi;
        player = playerapi.player;
    }

    public void beforeLocalConstructing(MinecraftServer minecraftserver, World world, String s, ItemInWorldManager iteminworldmanager)
    {
    }

    public void afterLocalConstructing(MinecraftServer minecraftserver, World world, String s, ItemInWorldManager iteminworldmanager)
    {
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    public void beforeAttackEntityFrom(DamageSource damagesource, int i)
    {
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenAttackEntityFrom(this);
        boolean flag;

        if (playerbase == null)
        {
            flag = player.localAttackEntityFrom(damagesource, i);
        }
        else if (playerbase != this)
        {
            flag = playerbase.attackEntityFrom(damagesource, i);
        }
        else
        {
            flag = false;
        }

        return flag;
    }

    public void afterAttackEntityFrom(DamageSource damagesource, int i)
    {
    }

    public void beforeAttackTargetEntityWithCurrentItem(Entity entity)
    {
    }

    public void attackTargetEntityWithCurrentItem(Entity entity)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenAttackTargetEntityWithCurrentItem(this);

        if (playerbase == null)
        {
            player.localAttackTargetEntityWithCurrentItem(entity);
        }
        else if (playerbase != this)
        {
            playerbase.attackTargetEntityWithCurrentItem(entity);
        }
    }

    public void afterAttackTargetEntityWithCurrentItem(Entity entity)
    {
    }

    public void beforeCanHarvestBlock(Block block)
    {
    }

    public boolean canHarvestBlock(Block block)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenCanHarvestBlock(this);
        boolean flag;

        if (playerbase == null)
        {
            flag = player.localCanHarvestBlock(block);
        }
        else if (playerbase != this)
        {
            flag = playerbase.canHarvestBlock(block);
        }
        else
        {
            flag = false;
        }

        return flag;
    }

    public void afterCanHarvestBlock(Block block)
    {
    }

    public void beforeCanPlayerEdit(int i, int j, int k)
    {
    }

    public boolean canPlayerEdit(int i, int j, int k)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenCanPlayerEdit(this);
        boolean flag;

        if (playerbase == null)
        {
            flag = player.localCanPlayerEdit(i, j, k);
        }
        else if (playerbase != this)
        {
            flag = playerbase.canPlayerEdit(i, j, k);
        }
        else
        {
            flag = false;
        }

        return flag;
    }

    public void afterCanPlayerEdit(int i, int j, int k)
    {
    }

    public void beforeCanTriggerWalking()
    {
    }

    public boolean canTriggerWalking()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenCanTriggerWalking(this);
        boolean flag;

        if (playerbase == null)
        {
            flag = player.localCanTriggerWalking();
        }
        else if (playerbase != this)
        {
            flag = playerbase.canTriggerWalking();
        }
        else
        {
            flag = false;
        }

        return flag;
    }

    public void afterCanTriggerWalking()
    {
    }

    public void beforeDamageEntity(DamageSource damagesource, int i)
    {
    }

    public void damageEntity(DamageSource damagesource, int i)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDamageEntity(this);

        if (playerbase == null)
        {
            player.localDamageEntity(damagesource, i);
        }
        else if (playerbase != this)
        {
            playerbase.damageEntity(damagesource, i);
        }
    }

    public void afterDamageEntity(DamageSource damagesource, int i)
    {
    }

    public void beforeDisplayGUIChest(IInventory iinventory)
    {
    }

    public void displayGUIChest(IInventory iinventory)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDisplayGUIChest(this);

        if (playerbase == null)
        {
            player.localDisplayGUIChest(iinventory);
        }
        else if (playerbase != this)
        {
            playerbase.displayGUIChest(iinventory);
        }
    }

    public void afterDisplayGUIChest(IInventory iinventory)
    {
    }

    public void beforeDisplayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
    }

    public void displayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDisplayGUIDispenser(this);

        if (playerbase == null)
        {
            player.localDisplayGUIDispenser(tileentitydispenser);
        }
        else if (playerbase != this)
        {
            playerbase.displayGUIDispenser(tileentitydispenser);
        }
    }

    public void afterDisplayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
    }

    public void beforeDisplayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
    }

    public void displayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDisplayGUIFurnace(this);

        if (playerbase == null)
        {
            player.localDisplayGUIFurnace(tileentityfurnace);
        }
        else if (playerbase != this)
        {
            playerbase.displayGUIFurnace(tileentityfurnace);
        }
    }

    public void afterDisplayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
    }

    public void beforeDisplayWorkbenchGUI(int i, int j, int k)
    {
    }

    public void displayWorkbenchGUI(int i, int j, int k)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDisplayWorkbenchGUI(this);

        if (playerbase == null)
        {
            player.localDisplayWorkbenchGUI(i, j, k);
        }
        else if (playerbase != this)
        {
            playerbase.displayWorkbenchGUI(i, j, k);
        }
    }

    public void afterDisplayWorkbenchGUI(int i, int j, int k)
    {
    }

    public void beforeDropOneItem()
    {
    }

    public EntityItem dropOneItem()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDropOneItem(this);
        EntityItem entityitem;

        if (playerbase == null)
        {
            entityitem = player.localDropOneItem();
        }
        else if (playerbase != this)
        {
            entityitem = playerbase.dropOneItem();
        }
        else
        {
            entityitem = null;
        }

        return entityitem;
    }

    public void afterDropOneItem()
    {
    }

    public void beforeDropPlayerItem(ItemStack itemstack)
    {
    }

    public EntityItem dropPlayerItem(ItemStack itemstack)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDropPlayerItem(this);
        EntityItem entityitem;

        if (playerbase == null)
        {
            entityitem = player.localDropPlayerItem(itemstack);
        }
        else if (playerbase != this)
        {
            entityitem = playerbase.dropPlayerItem(itemstack);
        }
        else
        {
            entityitem = null;
        }

        return entityitem;
    }

    public void afterDropPlayerItem(ItemStack itemstack)
    {
    }

    public void beforeFall(float f)
    {
    }

    public void fall(float f)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenFall(this);

        if (playerbase == null)
        {
            player.localFall(f);
        }
        else if (playerbase != this)
        {
            playerbase.fall(f);
        }
    }

    public void afterFall(float f)
    {
    }

    public void beforeGetCurrentPlayerStrVsBlock(Block block)
    {
    }

    public float getCurrentPlayerStrVsBlock(Block block)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetCurrentPlayerStrVsBlock(this);
        float f;

        if (playerbase == null)
        {
            f = player.localGetCurrentPlayerStrVsBlock(block);
        }
        else if (playerbase != this)
        {
            f = playerbase.getCurrentPlayerStrVsBlock(block);
        }
        else
        {
            f = 0.0F;
        }

        return f;
    }

    public void afterGetCurrentPlayerStrVsBlock(Block block)
    {
    }

    public void beforeGetDistanceSq(double d, double d1, double d2)
    {
    }

    public double getDistanceSq(double d, double d1, double d2)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetDistanceSq(this);
        double d3;

        if (playerbase == null)
        {
            d3 = player.localGetDistanceSq(d, d1, d2);
        }
        else if (playerbase != this)
        {
            d3 = playerbase.getDistanceSq(d, d1, d2);
        }
        else
        {
            d3 = 0.0D;
        }

        return d3;
    }

    public void afterGetDistanceSq(double d, double d1, double d2)
    {
    }

    public void beforeGetBrightness(float f)
    {
    }

    public float getBrightness(float f)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetBrightness(this);
        float f1;

        if (playerbase == null)
        {
            f1 = player.localGetBrightness(f);
        }
        else if (playerbase != this)
        {
            f1 = playerbase.getBrightness(f);
        }
        else
        {
            f1 = 0.0F;
        }

        return f1;
    }

    public void afterGetBrightness(float f)
    {
    }

    public void beforeGetEyeHeight()
    {
    }

    public float getEyeHeight()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetEyeHeight(this);
        float f;

        if (playerbase == null)
        {
            f = player.localGetEyeHeight();
        }
        else if (playerbase != this)
        {
            f = playerbase.getEyeHeight();
        }
        else
        {
            f = 0.0F;
        }

        return f;
    }

    public void afterGetEyeHeight()
    {
    }

    public void beforeHeal(int i)
    {
    }

    public void heal(int i)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenHeal(this);

        if (playerbase == null)
        {
            player.localHeal(i);
        }
        else if (playerbase != this)
        {
            playerbase.heal(i);
        }
    }

    public void afterHeal(int i)
    {
    }

    public void beforeInteract(EntityPlayer entityplayer)
    {
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenInteract(this);
        boolean flag;

        if (playerbase == null)
        {
            flag = player.localInteract(entityplayer);
        }
        else if (playerbase != this)
        {
            flag = playerbase.interact(entityplayer);
        }
        else
        {
            flag = false;
        }

        return flag;
    }

    public void afterInteract(EntityPlayer entityplayer)
    {
    }

    public void beforeIsEntityInsideOpaqueBlock()
    {
    }

    public boolean isEntityInsideOpaqueBlock()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsEntityInsideOpaqueBlock(this);
        boolean flag;

        if (playerbase == null)
        {
            flag = player.localIsEntityInsideOpaqueBlock();
        }
        else if (playerbase != this)
        {
            flag = playerbase.isEntityInsideOpaqueBlock();
        }
        else
        {
            flag = false;
        }

        return flag;
    }

    public void afterIsEntityInsideOpaqueBlock()
    {
    }

    public void beforeIsInWater()
    {
    }

    public boolean isInWater()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsInWater(this);
        boolean flag;

        if (playerbase == null)
        {
            flag = player.localIsInWater();
        }
        else if (playerbase != this)
        {
            flag = playerbase.isInWater();
        }
        else
        {
            flag = false;
        }

        return flag;
    }

    public void afterIsInWater()
    {
    }

    public void beforeIsInsideOfMaterial(Material material)
    {
    }

    public boolean isInsideOfMaterial(Material material)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsInsideOfMaterial(this);
        boolean flag;

        if (playerbase == null)
        {
            flag = player.localIsInsideOfMaterial(material);
        }
        else if (playerbase != this)
        {
            flag = playerbase.isInsideOfMaterial(material);
        }
        else
        {
            flag = false;
        }

        return flag;
    }

    public void afterIsInsideOfMaterial(Material material)
    {
    }

    public void beforeIsOnLadder()
    {
    }

    public boolean isOnLadder()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsOnLadder(this);
        boolean flag;

        if (playerbase == null)
        {
            flag = player.localIsOnLadder();
        }
        else if (playerbase != this)
        {
            flag = playerbase.isOnLadder();
        }
        else
        {
            flag = false;
        }

        return flag;
    }

    public void afterIsOnLadder()
    {
    }

    public void beforeIsPlayerSleeping()
    {
    }

    public boolean isPlayerSleeping()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsPlayerSleeping(this);
        boolean flag;

        if (playerbase == null)
        {
            flag = player.localIsPlayerSleeping();
        }
        else if (playerbase != this)
        {
            flag = playerbase.isPlayerSleeping();
        }
        else
        {
            flag = false;
        }

        return flag;
    }

    public void afterIsPlayerSleeping()
    {
    }

    public void beforeJump()
    {
    }

    public void jump()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenJump(this);

        if (playerbase == null)
        {
            player.localJump();
        }
        else if (playerbase != this)
        {
            playerbase.jump();
        }
    }

    public void afterJump()
    {
    }

    public void beforeMoveEntity(double d, double d1, double d2)
    {
    }

    public void moveEntity(double d, double d1, double d2)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenMoveEntity(this);

        if (playerbase == null)
        {
            player.localMoveEntity(d, d1, d2);
        }
        else if (playerbase != this)
        {
            playerbase.moveEntity(d, d1, d2);
        }
    }

    public void afterMoveEntity(double d, double d1, double d2)
    {
    }

    public void beforeMoveEntityWithHeading(float f, float f1)
    {
    }

    public void moveEntityWithHeading(float f, float f1)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenMoveEntityWithHeading(this);

        if (playerbase == null)
        {
            player.localMoveEntityWithHeading(f, f1);
        }
        else if (playerbase != this)
        {
            playerbase.moveEntityWithHeading(f, f1);
        }
    }

    public void afterMoveEntityWithHeading(float f, float f1)
    {
    }

    public void beforeMoveFlying(float f, float f1, float f2)
    {
    }

    public void moveFlying(float f, float f1, float f2)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenMoveFlying(this);

        if (playerbase == null)
        {
            player.localMoveFlying(f, f1, f2);
        }
        else if (playerbase != this)
        {
            playerbase.moveFlying(f, f1, f2);
        }
    }

    public void afterMoveFlying(float f, float f1, float f2)
    {
    }

    public void beforeOnDeath(DamageSource damagesource)
    {
    }

    public void onDeath(DamageSource damagesource)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenOnDeath(this);

        if (playerbase == null)
        {
            player.localOnDeath(damagesource);
        }
        else if (playerbase != this)
        {
            playerbase.onDeath(damagesource);
        }
    }

    public void afterOnDeath(DamageSource damagesource)
    {
    }

    public void beforeOnLivingUpdate()
    {
    }

    public void onLivingUpdate()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenOnLivingUpdate(this);

        if (playerbase == null)
        {
            player.localOnLivingUpdate();
        }
        else if (playerbase != this)
        {
            playerbase.onLivingUpdate();
        }
    }

    public void afterOnLivingUpdate()
    {
    }

    public void beforeOnKillEntity(EntityLiving entityliving)
    {
    }

    public void onKillEntity(EntityLiving entityliving)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenOnKillEntity(this);

        if (playerbase == null)
        {
            player.localOnKillEntity(entityliving);
        }
        else if (playerbase != this)
        {
            playerbase.onKillEntity(entityliving);
        }
    }

    public void afterOnKillEntity(EntityLiving entityliving)
    {
    }

    public void beforeOnUpdate()
    {
    }

    public void onUpdate()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenOnUpdate(this);

        if (playerbase == null)
        {
            player.localOnUpdate();
        }
        else if (playerbase != this)
        {
            playerbase.onUpdate();
        }
    }

    public void afterOnUpdate()
    {
    }

    public void beforeOnUpdateEntity(boolean flag)
    {
    }

    public void onUpdateEntity(boolean flag)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenOnUpdateEntity(this);

        if (playerbase == null)
        {
            player.localOnUpdateEntity(flag);
        }
        else if (playerbase != this)
        {
            playerbase.onUpdateEntity(flag);
        }
    }

    public void afterOnUpdateEntity(boolean flag)
    {
    }

    public void beforeReadEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenReadEntityFromNBT(this);

        if (playerbase == null)
        {
            player.localReadEntityFromNBT(nbttagcompound);
        }
        else if (playerbase != this)
        {
            playerbase.readEntityFromNBT(nbttagcompound);
        }
    }

    public void afterReadEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    public void beforeSetDead()
    {
    }

    public void setDead()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenSetDead(this);

        if (playerbase == null)
        {
            player.localSetDead();
        }
        else if (playerbase != this)
        {
            playerbase.setDead();
        }
    }

    public void afterSetDead()
    {
    }

    public void beforeSetPosition(double d, double d1, double d2)
    {
    }

    public void setPosition(double d, double d1, double d2)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenSetPosition(this);

        if (playerbase == null)
        {
            player.localSetPosition(d, d1, d2);
        }
        else if (playerbase != this)
        {
            playerbase.setPosition(d, d1, d2);
        }
    }

    public void afterSetPosition(double d, double d1, double d2)
    {
    }

    public void beforeUpdateEntityActionState()
    {
    }

    public void updateEntityActionState()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenUpdateEntityActionState(this);

        if (playerbase == null)
        {
            player.localUpdateEntityActionState();
        }
        else if (playerbase != this)
        {
            playerbase.updateEntityActionState();
        }
    }

    public void afterUpdateEntityActionState()
    {
    }

    public void beforeWriteEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenWriteEntityToNBT(this);

        if (playerbase == null)
        {
            player.localWriteEntityToNBT(nbttagcompound);
        }
        else if (playerbase != this)
        {
            playerbase.writeEntityToNBT(nbttagcompound);
        }
    }

    public void afterWriteEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }
}
