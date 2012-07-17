package net.minecraft.src;

import java.util.*;
import net.minecraft.server.MinecraftServer;

public class EntityPlayerMP extends EntityPlayer implements ICrafting
{
    /** The NetServerHandler for this particular player. */
    public NetServerHandler playerNetServerHandler;

    /** Reference to the MinecraftServer object. */
    public MinecraftServer mcServer;

    /** The ItemInWorldManager belonging to this player */
    public ItemInWorldManager itemInWorldManager;

    /** player X position as seen by PlayerManager */
    public double managedPosX;

    /** player Z position as seen by PlayerManager */
    public double managedPosZ;

    /** LinkedList that holds loaded chunks */
    public List loadedChunks;

    /**
     * set of ChunkCoordIntPair, represents blocks that the player will receive block updates from
     */
    public Set listeningChunks;

    /** amount of health the client was last set to */
    private int lastHealth;
    private int field_35221_cc;
    private boolean field_35222_cd;

    /** Amount of experience the client was last set to */
    private int lastExperience;

    /** how many ticks of invulnerability(spawn protection) this player has */
    private int ticksOfInvuln;
    private ItemStack playerInventory[];

    /** the currently in use window id */
    private int currentWindowId;

    /**
     * set to true when player is moving quantity of items from one inventory to another(crafting) but item in either
     * slot is not changed
     */
    public boolean isChangingQuantityOnly;
    public int ping;

    /**
     * Set when a player beats the ender dragon, used to determine whether a Packet9Respawn is valid.
     */
    public boolean gameOver;
    protected final PlayerAPI playerAPI = PlayerAPI.create(this);

    public EntityPlayerMP(MinecraftServer par1MinecraftServer, World par2World, String par3Str, ItemInWorldManager par4ItemInWorldManager)
    {
        super(par2World);
        PlayerAPI.beforeLocalConstructing(this, par1MinecraftServer, par2World, par3Str, par4ItemInWorldManager);
        loadedChunks = new LinkedList();
        listeningChunks = new HashSet();
        lastHealth = 0xfa0a1f01;
        field_35221_cc = 0xfa0a1f01;
        field_35222_cd = true;
        lastExperience = 0xfa0a1f01;
        ticksOfInvuln = 60;
        playerInventory = new ItemStack[5];
        currentWindowId = 0;
        gameOver = false;
        par4ItemInWorldManager.thisPlayer = this;
        itemInWorldManager = par4ItemInWorldManager;
        ChunkCoordinates chunkcoordinates = par2World.getSpawnPoint();
        int i = chunkcoordinates.posX;
        int j = chunkcoordinates.posZ;
        int k = chunkcoordinates.posY;

        if (!par2World.worldProvider.hasNoSky)
        {
            i += rand.nextInt(20) - 10;
            k = par2World.getTopSolidOrLiquidBlock(i, j);
            j += rand.nextInt(20) - 10;
        }

        setLocationAndAngles((double)i + 0.5D, k, (double)j + 0.5D, 0.0F, 0.0F);
        mcServer = par1MinecraftServer;
        stepHeight = 0.0F;
        username = par3Str;
        yOffset = 0.0F;
        PlayerAPI.afterLocalConstructing(this, par1MinecraftServer, par2World, par3Str, par4ItemInWorldManager);
    }

    public final PlayerBase getPlayerBase(String s)
    {
        if (playerAPI != null)
        {
            return playerAPI.getPlayerBase(s);
        }
        else
        {
            return null;
        }
    }

    public final Set getPlayerBaseIds(String s)
    {
        if (playerAPI != null)
        {
            return playerAPI.getPlayerBaseIds();
        }
        else
        {
            return Collections.emptySet();
        }
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        boolean flag;

        if (playerAPI != null && playerAPI.isAttackEntityFromModded)
        {
            flag = PlayerAPI.attackEntityFrom(this, par1DamageSource, par2);
        }
        else
        {
            flag = localAttackEntityFrom(par1DamageSource, par2);
        }

        return flag;
    }

    public final boolean superAttackEntityFrom(DamageSource damagesource, int i)
    {
        return super.attackEntityFrom(damagesource, i);
    }

    public final boolean localAttackEntityFrom(DamageSource damagesource, int i)
    {
        if (ticksOfInvuln > 0)
        {
            return false;
        }

        if (!mcServer.pvpOn && (damagesource instanceof EntityDamageSource))
        {
            Entity entity = damagesource.getEntity();

            if (entity instanceof EntityPlayer)
            {
                return false;
            }

            if (entity instanceof EntityArrow)
            {
                EntityArrow entityarrow = (EntityArrow)entity;

                if (entityarrow.shootingEntity instanceof EntityPlayer)
                {
                    return false;
                }
            }
        }

        return super.attackEntityFrom(damagesource, i);
    }

    /**
     * Attacks for the player the targeted entity with the currently equipped item.  The equipped item has hitEntity
     * called on it. Args: targetEntity
     */
    public void attackTargetEntityWithCurrentItem(Entity entity)
    {
        if (playerAPI != null && playerAPI.isAttackTargetEntityWithCurrentItemModded)
        {
            PlayerAPI.attackTargetEntityWithCurrentItem(this, entity);
        }
        else
        {
            super.attackTargetEntityWithCurrentItem(entity);
        }
    }

    public final void superAttackTargetEntityWithCurrentItem(Entity entity)
    {
        super.attackTargetEntityWithCurrentItem(entity);
    }

    public final void localAttackTargetEntityWithCurrentItem(Entity entity)
    {
        super.attackTargetEntityWithCurrentItem(entity);
    }

    /**
     * Checks if the player has the ability to harvest a block (checks current inventory item for a tool if necessary)
     */
    public boolean canHarvestBlock(Block block)
    {
        boolean flag;

        if (playerAPI != null && playerAPI.isCanHarvestBlockModded)
        {
            flag = PlayerAPI.canHarvestBlock(this, block);
        }
        else
        {
            flag = super.canHarvestBlock(block);
        }

        return flag;
    }

    public final boolean superCanHarvestBlock(Block block)
    {
        return super.canHarvestBlock(block);
    }

    public final boolean localCanHarvestBlock(Block block)
    {
        return super.canHarvestBlock(block);
    }

    public boolean canPlayerEdit(int i, int j, int k)
    {
        boolean flag;

        if (playerAPI != null && playerAPI.isCanPlayerEditModded)
        {
            flag = PlayerAPI.canPlayerEdit(this, i, j, k);
        }
        else
        {
            flag = super.canPlayerEdit(i, j, k);
        }

        return flag;
    }

    public final boolean superCanPlayerEdit(int i, int j, int k)
    {
        return super.canPlayerEdit(i, j, k);
    }

    public final boolean localCanPlayerEdit(int i, int j, int k)
    {
        return super.canPlayerEdit(i, j, k);
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        boolean flag;

        if (playerAPI != null && playerAPI.isCanTriggerWalkingModded)
        {
            flag = PlayerAPI.canTriggerWalking(this);
        }
        else
        {
            flag = super.canTriggerWalking();
        }

        return flag;
    }

    public final boolean realCanTriggerWalking()
    {
        return canTriggerWalking();
    }

    public final boolean superCanTriggerWalking()
    {
        return super.canTriggerWalking();
    }

    public final boolean localCanTriggerWalking()
    {
        return super.canTriggerWalking();
    }

    /**
     * Deals damage to the entity. If its a EntityPlayer then will take damage from the armor first and then health
     * second with the reduced value. Args: damageAmount
     */
    protected void damageEntity(DamageSource damagesource, int i)
    {
        if (playerAPI != null && playerAPI.isDamageEntityModded)
        {
            PlayerAPI.damageEntity(this, damagesource, i);
        }
        else
        {
            super.damageEntity(damagesource, i);
        }
    }

    public final void realDamageEntity(DamageSource damagesource, int i)
    {
        damageEntity(damagesource, i);
    }

    public final void superDamageEntity(DamageSource damagesource, int i)
    {
        super.damageEntity(damagesource, i);
    }

    public final void localDamageEntity(DamageSource damagesource, int i)
    {
        super.damageEntity(damagesource, i);
    }

    /**
     * Displays the GUI for interacting with a chest inventory. Args: chestInventory
     */
    public void displayGUIChest(IInventory par1IInventory)
    {
        if (playerAPI != null && playerAPI.isDisplayGUIChestModded)
        {
            PlayerAPI.displayGUIChest(this, par1IInventory);
        }
        else
        {
            localDisplayGUIChest(par1IInventory);
        }
    }

    public final void superDisplayGUIChest(IInventory iinventory)
    {
        super.displayGUIChest(iinventory);
    }

    public final void localDisplayGUIChest(IInventory iinventory)
    {
        getNextWidowId();
        closeCraftingGui();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 0, iinventory.getInvName(), iinventory.getSizeInventory()));
        craftingInventory = new ContainerChest(inventory, iinventory);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    /**
     * Displays the dipsenser GUI for the passed in dispenser entity. Args: TileEntityDispenser
     */
    public void displayGUIDispenser(TileEntityDispenser par1TileEntityDispenser)
    {
        if (playerAPI != null && playerAPI.isDisplayGUIDispenserModded)
        {
            PlayerAPI.displayGUIDispenser(this, par1TileEntityDispenser);
        }
        else
        {
            localDisplayGUIDispenser(par1TileEntityDispenser);
        }
    }

    public final void superDisplayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
        super.displayGUIDispenser(tileentitydispenser);
    }

    public final void localDisplayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
        getNextWidowId();
        closeCraftingGui();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 3, tileentitydispenser.getInvName(), tileentitydispenser.getSizeInventory()));
        craftingInventory = new ContainerDispenser(inventory, tileentitydispenser);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    /**
     * Displays the furnace GUI for the passed in furnace entity. Args: tileEntityFurnace
     */
    public void displayGUIFurnace(TileEntityFurnace par1TileEntityFurnace)
    {
        if (playerAPI != null && playerAPI.isDisplayGUIFurnaceModded)
        {
            PlayerAPI.displayGUIFurnace(this, par1TileEntityFurnace);
        }
        else
        {
            localDisplayGUIFurnace(par1TileEntityFurnace);
        }
    }

    public final void superDisplayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
        super.displayGUIFurnace(tileentityfurnace);
    }

    public final void localDisplayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
        getNextWidowId();
        closeCraftingGui();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 2, tileentityfurnace.getInvName(), tileentityfurnace.getSizeInventory()));
        craftingInventory = new ContainerFurnace(inventory, tileentityfurnace);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    /**
     * Displays the crafting GUI for a workbench.
     */
    public void displayWorkbenchGUI(int par1, int par2, int par3)
    {
        if (playerAPI != null && playerAPI.isDisplayWorkbenchGUIModded)
        {
            PlayerAPI.displayWorkbenchGUI(this, par1, par2, par3);
        }
        else
        {
            localDisplayWorkbenchGUI(par1, par2, par3);
        }
    }

    public final void superDisplayWorkbenchGUI(int i, int j, int k)
    {
        super.displayWorkbenchGUI(i, j, k);
    }

    public final void localDisplayWorkbenchGUI(int i, int j, int k)
    {
        getNextWidowId();
        closeCraftingGui();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 1, "Crafting", 9));
        craftingInventory = new ContainerWorkbench(inventory, worldObj, i, j, k);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    /**
     * Called when player presses the drop item key
     */
    public EntityItem dropOneItem()
    {
        EntityItem entityitem;

        if (playerAPI != null && playerAPI.isDropOneItemModded)
        {
            entityitem = PlayerAPI.dropOneItem(this);
        }
        else
        {
            entityitem = super.dropOneItem();
        }

        return entityitem;
    }

    public final EntityItem superDropOneItem()
    {
        return super.dropOneItem();
    }

    public final EntityItem localDropOneItem()
    {
        return super.dropOneItem();
    }

    /**
     * Args: itemstack
     */
    public EntityItem dropPlayerItem(ItemStack itemstack)
    {
        EntityItem entityitem;

        if (playerAPI != null && playerAPI.isDropPlayerItemModded)
        {
            entityitem = PlayerAPI.dropPlayerItem(this, itemstack);
        }
        else
        {
            entityitem = super.dropPlayerItem(itemstack);
        }

        return entityitem;
    }

    public final EntityItem superDropPlayerItem(ItemStack itemstack)
    {
        return super.dropPlayerItem(itemstack);
    }

    public final EntityItem localDropPlayerItem(ItemStack itemstack)
    {
        return super.dropPlayerItem(itemstack);
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float f)
    {
        if (playerAPI != null && playerAPI.isFallModded)
        {
            PlayerAPI.fall(this, f);
        }
        else
        {
            super.fall(f);
        }
    }

    public final void realFall(float f)
    {
        fall(f);
    }

    public final void superFall(float f)
    {
        super.fall(f);
    }

    public final void localFall(float f)
    {
        super.fall(f);
    }

    /**
     * Returns how strong the player is against the specified block at this moment
     */
    public float getCurrentPlayerStrVsBlock(Block block)
    {
        float f;

        if (playerAPI != null && playerAPI.isGetCurrentPlayerStrVsBlockModded)
        {
            f = PlayerAPI.getCurrentPlayerStrVsBlock(this, block);
        }
        else
        {
            f = super.getCurrentPlayerStrVsBlock(block);
        }

        return f;
    }

    public final float superGetCurrentPlayerStrVsBlock(Block block)
    {
        return super.getCurrentPlayerStrVsBlock(block);
    }

    public final float localGetCurrentPlayerStrVsBlock(Block block)
    {
        return super.getCurrentPlayerStrVsBlock(block);
    }

    /**
     * Gets the squared distance to the position. Args: x, y, z
     */
    public double getDistanceSq(double d, double d1, double d2)
    {
        double d3;

        if (playerAPI != null && playerAPI.isGetDistanceSqModded)
        {
            d3 = PlayerAPI.getDistanceSq(this, d, d1, d2);
        }
        else
        {
            d3 = super.getDistanceSq(d, d1, d2);
        }

        return d3;
    }

    public final double superGetDistanceSq(double d, double d1, double d2)
    {
        return super.getDistanceSq(d, d1, d2);
    }

    public final double localGetDistanceSq(double d, double d1, double d2)
    {
        return super.getDistanceSq(d, d1, d2);
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float f)
    {
        float f1;

        if (playerAPI != null && playerAPI.isGetBrightnessModded)
        {
            f1 = PlayerAPI.getBrightness(this, f);
        }
        else
        {
            f1 = super.getBrightness(f);
        }

        return f1;
    }

    public final float superGetBrightness(float f)
    {
        return super.getBrightness(f);
    }

    public final float localGetBrightness(float f)
    {
        return super.getBrightness(f);
    }

    public float getEyeHeight()
    {
        float f;

        if (playerAPI != null && playerAPI.isGetEyeHeightModded)
        {
            f = PlayerAPI.getEyeHeight(this);
        }
        else
        {
            f = localGetEyeHeight();
        }

        return f;
    }

    public final float superGetEyeHeight()
    {
        return super.getEyeHeight();
    }

    public final float localGetEyeHeight()
    {
        return 1.62F;
    }

    /**
     * Heal living entity (param: amount of half-hearts)
     */
    public void heal(int par1)
    {
        if (playerAPI != null && playerAPI.isHealModded)
        {
            PlayerAPI.heal(this, par1);
        }
        else
        {
            localHeal(par1);
        }
    }

    public final void superHeal(int i)
    {
        super.heal(i);
    }

    public final void localHeal(int i)
    {
        super.heal(i);
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer entityplayer)
    {
        boolean flag;

        if (playerAPI != null && playerAPI.isInteractModded)
        {
            flag = PlayerAPI.interact(this, entityplayer);
        }
        else
        {
            flag = super.interact(entityplayer);
        }

        return flag;
    }

    public final boolean superInteract(EntityPlayer entityplayer)
    {
        return super.interact(entityplayer);
    }

    public final boolean localInteract(EntityPlayer entityplayer)
    {
        return super.interact(entityplayer);
    }

    /**
     * Checks if this entity is inside of an opaque block
     */
    public boolean isEntityInsideOpaqueBlock()
    {
        boolean flag;

        if (playerAPI != null && playerAPI.isIsEntityInsideOpaqueBlockModded)
        {
            flag = PlayerAPI.isEntityInsideOpaqueBlock(this);
        }
        else
        {
            flag = super.isEntityInsideOpaqueBlock();
        }

        return flag;
    }

    public final boolean superIsEntityInsideOpaqueBlock()
    {
        return super.isEntityInsideOpaqueBlock();
    }

    public final boolean localIsEntityInsideOpaqueBlock()
    {
        return super.isEntityInsideOpaqueBlock();
    }

    /**
     * Checks if this entity is inside water (if inWater field is true as a result of handleWaterMovement() returning
     * true)
     */
    public boolean isInWater()
    {
        boolean flag;

        if (playerAPI != null && playerAPI.isIsInWaterModded)
        {
            flag = PlayerAPI.isInWater(this);
        }
        else
        {
            flag = super.isInWater();
        }

        return flag;
    }

    public final boolean superIsInWater()
    {
        return super.isInWater();
    }

    public final boolean localIsInWater()
    {
        return super.isInWater();
    }

    /**
     * Checks if the current block the entity is within of the specified material type
     */
    public boolean isInsideOfMaterial(Material material)
    {
        boolean flag;

        if (playerAPI != null && playerAPI.isIsInsideOfMaterialModded)
        {
            flag = PlayerAPI.isInsideOfMaterial(this, material);
        }
        else
        {
            flag = super.isInsideOfMaterial(material);
        }

        return flag;
    }

    public final boolean superIsInsideOfMaterial(Material material)
    {
        return super.isInsideOfMaterial(material);
    }

    public final boolean localIsInsideOfMaterial(Material material)
    {
        return super.isInsideOfMaterial(material);
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    public boolean isOnLadder()
    {
        boolean flag;

        if (playerAPI != null && playerAPI.isIsOnLadderModded)
        {
            flag = PlayerAPI.isOnLadder(this);
        }
        else
        {
            flag = super.isOnLadder();
        }

        return flag;
    }

    public final boolean superIsOnLadder()
    {
        return super.isOnLadder();
    }

    public final boolean localIsOnLadder()
    {
        return super.isOnLadder();
    }

    /**
     * Returns whether player is sleeping or not
     */
    public boolean isPlayerSleeping()
    {
        boolean flag;

        if (playerAPI != null && playerAPI.isIsPlayerSleepingModded)
        {
            flag = PlayerAPI.isPlayerSleeping(this);
        }
        else
        {
            flag = super.isPlayerSleeping();
        }

        return flag;
    }

    public final boolean superIsPlayerSleeping()
    {
        return super.isPlayerSleeping();
    }

    public final boolean localIsPlayerSleeping()
    {
        return super.isPlayerSleeping();
    }

    /**
     * causes this entity to jump (or at least move upwards)
     */
    protected void jump()
    {
        if (playerAPI != null && playerAPI.isJumpModded)
        {
            PlayerAPI.jump(this);
        }
        else
        {
            super.jump();
        }
    }

    public final void realJump()
    {
        jump();
    }

    public final void superJump()
    {
        super.jump();
    }

    public final void localJump()
    {
        super.jump();
    }

    /**
     * Tries to moves the entity by the passed in displacement. Args: x, y, z
     */
    public void moveEntity(double d, double d1, double d2)
    {
        if (playerAPI != null && playerAPI.isMoveEntityModded)
        {
            PlayerAPI.moveEntity(this, d, d1, d2);
        }
        else
        {
            super.moveEntity(d, d1, d2);
        }
    }

    public final void superMoveEntity(double d, double d1, double d2)
    {
        super.moveEntity(d, d1, d2);
    }

    public final void localMoveEntity(double d, double d1, double d2)
    {
        super.moveEntity(d, d1, d2);
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float f, float f1)
    {
        if (playerAPI != null && playerAPI.isMoveEntityWithHeadingModded)
        {
            PlayerAPI.moveEntityWithHeading(this, f, f1);
        }
        else
        {
            super.moveEntityWithHeading(f, f1);
        }
    }

    public final void superMoveEntityWithHeading(float f, float f1)
    {
        super.moveEntityWithHeading(f, f1);
    }

    public final void localMoveEntityWithHeading(float f, float f1)
    {
        super.moveEntityWithHeading(f, f1);
    }

    /**
     * Used in both water and by flying objects
     */
    public void moveFlying(float f, float f1, float f2)
    {
        if (playerAPI != null && playerAPI.isMoveFlyingModded)
        {
            PlayerAPI.moveFlying(this, f, f1, f2);
        }
        else
        {
            super.moveFlying(f, f1, f2);
        }
    }

    public final void superMoveFlying(float f, float f1, float f2)
    {
        super.moveFlying(f, f1, f2);
    }

    public final void localMoveFlying(float f, float f1, float f2)
    {
        super.moveFlying(f, f1, f2);
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        if (playerAPI != null && playerAPI.isOnDeathModded)
        {
            PlayerAPI.onDeath(this, par1DamageSource);
        }
        else
        {
            localOnDeath(par1DamageSource);
        }
    }

    public final void superOnDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);
    }

    public final void localOnDeath(DamageSource damagesource)
    {
        mcServer.configManager.sendPacketToAllPlayers(new Packet3Chat(damagesource.getDeathMessage(this)));
        inventory.dropAllItems();
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (playerAPI != null && playerAPI.isOnLivingUpdateModded)
        {
            PlayerAPI.onLivingUpdate(this);
        }
        else
        {
            super.onLivingUpdate();
        }
    }

    public final void superOnLivingUpdate()
    {
        super.onLivingUpdate();
    }

    public final void localOnLivingUpdate()
    {
        super.onLivingUpdate();
    }

    /**
     * This method gets called when the entity kills another one.
     */
    public void onKillEntity(EntityLiving entityliving)
    {
        if (playerAPI != null && playerAPI.isOnKillEntityModded)
        {
            PlayerAPI.onKillEntity(this, entityliving);
        }
        else
        {
            super.onKillEntity(entityliving);
        }
    }

    public final void superOnKillEntity(EntityLiving entityliving)
    {
        super.onKillEntity(entityliving);
    }

    public final void localOnKillEntity(EntityLiving entityliving)
    {
        super.onKillEntity(entityliving);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        if (playerAPI != null && playerAPI.isOnUpdateModded)
        {
            PlayerAPI.onUpdate(this);
        }
        else
        {
            localOnUpdate();
        }
    }

    public final void superOnUpdate()
    {
        super.onUpdate();
    }

    public final void localOnUpdate()
    {
        itemInWorldManager.updateBlockRemoving();
        ticksOfInvuln--;
        craftingInventory.updateCraftingResults();

        for (int i = 0; i < 5; i++)
        {
            ItemStack itemstack = getEquipmentInSlot(i);

            if (itemstack != playerInventory[i])
            {
                mcServer.getEntityTracker(dimension).sendPacketToTrackedPlayers(this, new Packet5PlayerInventory(entityId, i, itemstack));
                playerInventory[i] = itemstack;
            }
        }
    }

    /**
     * updates the player, also has a flag to tell the server if it should update chunks or not(wanted onUpdate(because
     * this calls super.onUpdate) but already one in this class)
     */
    public void onUpdateEntity(boolean par1)
    {
        if (playerAPI != null && playerAPI.isOnUpdateEntityModded)
        {
            PlayerAPI.onUpdateEntity(this, par1);
        }
        else
        {
            localOnUpdateEntity(par1);
        }
    }

    public final void localOnUpdateEntity(boolean flag)
    {
        label0:
        {
            super.onUpdate();

            for (int i = 0; i < inventory.getSizeInventory(); i++)
            {
                ItemStack itemstack = inventory.getStackInSlot(i);

                if (itemstack == null || !Item.itemsList[itemstack.itemID].func_28019_b() || playerNetServerHandler.getNumChunkDataPackets() > 2)
                {
                    continue;
                }

                Packet packet = ((ItemMapBase)Item.itemsList[itemstack.itemID]).getUpdatePacket(itemstack, worldObj, this);

                if (packet != null)
                {
                    playerNetServerHandler.sendPacket(packet);
                }
            }

            if (flag && !loadedChunks.isEmpty())
            {
                ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)loadedChunks.get(0);
                double d = ((ChunkCoordIntPair)chunkcoordintpair).func_48477_a(this);

                for (int j = 0; j < loadedChunks.size(); j++)
                {
                    ChunkCoordIntPair chunkcoordintpair1 = (ChunkCoordIntPair)loadedChunks.get(j);
                    double d1 = ((ChunkCoordIntPair)chunkcoordintpair1).func_48477_a(this);

                    if (d1 < d)
                    {
                        chunkcoordintpair = chunkcoordintpair1;
                        d = d1;
                    }
                }

                if (chunkcoordintpair != null)
                {
                    boolean flag1 = false;

                    if (playerNetServerHandler.getNumChunkDataPackets() < 4)
                    {
                        flag1 = true;
                    }

                    if (flag1)
                    {
                        WorldServer worldserver = mcServer.getWorldManager(dimension);

                        if (((WorldServer)worldserver).blockExists(((ChunkCoordIntPair)chunkcoordintpair).chunkXPos << 4, 0, ((ChunkCoordIntPair)chunkcoordintpair).chunkZPos << 4))
                        {
                            Chunk chunk = ((WorldServer)worldserver).getChunkFromChunkCoords(((ChunkCoordIntPair)chunkcoordintpair).chunkXPos, ((ChunkCoordIntPair)chunkcoordintpair).chunkZPos);

                            if (chunk.isTerrainPopulated)
                            {
                                loadedChunks.remove(chunkcoordintpair);
                                playerNetServerHandler.sendPacket(new Packet51MapChunk(((WorldServer)worldserver).getChunkFromChunkCoords(((ChunkCoordIntPair)chunkcoordintpair).chunkXPos, ((ChunkCoordIntPair)chunkcoordintpair).chunkZPos), true, 0));
                                List list = ((WorldServer)worldserver).getTileEntityList(((ChunkCoordIntPair)chunkcoordintpair).chunkXPos * 16, 0, ((ChunkCoordIntPair)chunkcoordintpair).chunkZPos * 16, ((ChunkCoordIntPair)chunkcoordintpair).chunkXPos * 16 + 16, 256, ((ChunkCoordIntPair)chunkcoordintpair).chunkZPos * 16 + 16);

                                for (int k = 0; k < list.size(); k++)
                                {
                                    getTileEntityInfo((TileEntity)list.get(k));
                                }
                            }
                        }
                    }
                }
            }

            if (inPortal)
            {
                if (mcServer.propertyManagerObj.getBooleanProperty("allow-nether", true))
                {
                    if (craftingInventory != inventorySlots)
                    {
                        closeScreen();
                    }

                    if (ridingEntity != null)
                    {
                        mountEntity(ridingEntity);
                    }
                    else
                    {
                        timeInPortal += 0.0125F;

                        if (timeInPortal >= 1.0F)
                        {
                            timeInPortal = 1.0F;
                            timeUntilPortal = 10;
                            byte byte0 = 0;

                            if (dimension == -1)
                            {
                                byte0 = 0;
                            }
                            else
                            {
                                byte0 = -1;
                            }

                            mcServer.configManager.sendPlayerToOtherDimension(this, byte0);
                            lastExperience = -1;
                            lastHealth = -1;
                            field_35221_cc = -1;
                            triggerAchievement(AchievementList.portal);
                        }
                    }

                    inPortal = false;
                }
            }
            else
            {
                if (timeInPortal > 0.0F)
                {
                    timeInPortal -= 0.05F;
                }

                if (timeInPortal < 0.0F)
                {
                    timeInPortal = 0.0F;
                }
            }

            if (timeUntilPortal > 0)
            {
                timeUntilPortal--;
            }

            if (getHealth() == lastHealth && field_35221_cc == foodStats.getFoodLevel())
            {
                if ((foodStats.getSaturationLevel() == 0.0F) == field_35222_cd)
                {
                    break label0;
                }
                else
                {
                    break label0;
                }
            }

            playerNetServerHandler.sendPacket(new Packet8UpdateHealth(getHealth(), foodStats.getFoodLevel(), foodStats.getSaturationLevel()));
            lastHealth = getHealth();
            field_35221_cc = foodStats.getFoodLevel();
            field_35222_cd = foodStats.getSaturationLevel() == 0.0F;
        }

        if (experienceTotal != lastExperience)
        {
            lastExperience = experienceTotal;
            playerNetServerHandler.sendPacket(new Packet43Experience(experience, experienceTotal, experienceLevel));
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        if (playerAPI != null && playerAPI.isReadEntityFromNBTModded)
        {
            PlayerAPI.readEntityFromNBT(this, par1NBTTagCompound);
        }
        else
        {
            localReadEntityFromNBT(par1NBTTagCompound);
        }
    }

    public final void superReadEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

    public final void localReadEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);

        if (nbttagcompound.hasKey("playerGameType"))
        {
            itemInWorldManager.toggleGameType(nbttagcompound.getInteger("playerGameType"));
        }
    }

    /**
     * Will get destroyed next tick.
     */
    public void setDead()
    {
        if (playerAPI != null && playerAPI.isSetDeadModded)
        {
            PlayerAPI.setDead(this);
        }
        else
        {
            super.setDead();
        }
    }

    public final void superSetDead()
    {
        super.setDead();
    }

    public final void localSetDead()
    {
        super.setDead();
    }

    /**
     * Sets the x,y,z of the entity from the given parameters. Also seems to set up a bounding box.
     */
    public void setPosition(double d, double d1, double d2)
    {
        if (playerAPI != null && playerAPI.isSetPositionModded)
        {
            PlayerAPI.setPosition(this, d, d1, d2);
        }
        else
        {
            super.setPosition(d, d1, d2);
        }
    }

    public final void superSetPosition(double d, double d1, double d2)
    {
        super.setPosition(d, d1, d2);
    }

    public final void localSetPosition(double d, double d1, double d2)
    {
        super.setPosition(d, d1, d2);
    }

    protected void updateEntityActionState()
    {
        if (playerAPI != null && playerAPI.isUpdateEntityActionStateModded)
        {
            PlayerAPI.updateEntityActionState(this);
        }
        else
        {
            super.updateEntityActionState();
        }
    }

    public final void realUpdateEntityActionState()
    {
        updateEntityActionState();
    }

    public final void superUpdateEntityActionState()
    {
        super.updateEntityActionState();
    }

    public final void localUpdateEntityActionState()
    {
        super.updateEntityActionState();
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        if (playerAPI != null && playerAPI.isWriteEntityToNBTModded)
        {
            PlayerAPI.writeEntityToNBT(this, par1NBTTagCompound);
        }
        else
        {
            localWriteEntityToNBT(par1NBTTagCompound);
        }
    }

    public final void superWriteEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public final void localWriteEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("playerGameType", itemInWorldManager.getGameType());
    }

    /**
     * Add a chat message to the player
     */
    public void addChatMessage(String par1Str)
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        String s = stringtranslate.translateKey(par1Str);
        playerNetServerHandler.sendPacket(new Packet3Chat(s));
    }

    public final void superAddChatMessage(String s)
    {
        super.addChatMessage(s);
    }

    public final boolean superAddEntityID(NBTTagCompound nbttagcompound)
    {
        return super.addEntityID(nbttagcompound);
    }

    public final void superAddExhaustion(float f)
    {
        super.addExhaustion(f);
    }

    public final void superAddExperience(int i)
    {
        super.addExperience(i);
    }

    public final void superAddMovementStat(double d, double d1, double d2)
    {
        super.addMovementStat(d, d1, d2);
    }

    public final void superAddPotionEffect(PotionEffect potioneffect)
    {
        super.addPotionEffect(potioneffect);
    }

    /**
     * Adds a value to a statistic field.
     */
    public void addStat(StatBase par1StatBase, int par2)
    {
        if (par1StatBase == null)
        {
            return;
        }

        if (!par1StatBase.isIndependent)
        {
            for (; par2 > 100; par2 -= 100)
            {
                playerNetServerHandler.sendPacket(new Packet200Statistic(par1StatBase.statId, 100));
            }

            playerNetServerHandler.sendPacket(new Packet200Statistic(par1StatBase.statId, par2));
        }
    }

    public final void superAddStat(StatBase statbase, int i)
    {
        super.addStat(statbase, i);
    }

    public final void superAddToPlayerScore(Entity entity, int i)
    {
        super.addToPlayerScore(entity, i);
    }

    public final void superAddVelocity(double d, double d1, double d2)
    {
        super.addVelocity(d, d1, d2);
    }

    public final void realAlertWolves(EntityLiving entityliving, boolean flag)
    {
        alertWolves(entityliving, flag);
    }

    public final void superAlertWolves(EntityLiving entityliving, boolean flag)
    {
        super.alertWolves(entityliving, flag);
    }

    public final int realApplyArmorCalculations(DamageSource damagesource, int i)
    {
        return applyArmorCalculations(damagesource, i);
    }

    public final int superApplyArmorCalculations(DamageSource damagesource, int i)
    {
        return super.applyArmorCalculations(damagesource, i);
    }

    public final void superApplyEntityCollision(Entity entity)
    {
        super.applyEntityCollision(entity);
    }

    public final int realApplyPotionDamageCalculations(DamageSource damagesource, int i)
    {
        return applyPotionDamageCalculations(damagesource, i);
    }

    public final int superApplyPotionDamageCalculations(DamageSource damagesource, int i)
    {
        return super.applyPotionDamageCalculations(damagesource, i);
    }

    public final boolean superAttackEntityAsMob(Entity entity)
    {
        return super.attackEntityAsMob(entity);
    }

    public final boolean superCanAttackWithItem()
    {
        return super.canAttackWithItem();
    }

    public final boolean superCanBeCollidedWith()
    {
        return super.canBeCollidedWith();
    }

    public final boolean superCanBePushed()
    {
        return super.canBePushed();
    }

    public final boolean superCanBreatheUnderwater()
    {
        return super.canBreatheUnderwater();
    }

    public final boolean realCanDespawn()
    {
        return canDespawn();
    }

    public final boolean superCanDespawn()
    {
        return super.canDespawn();
    }

    public final boolean superCanEat(boolean flag)
    {
        return super.canEat(flag);
    }

    public final boolean superCanEntityBeSeen(Entity entity)
    {
        return super.canEntityBeSeen(entity);
    }

    public final void superClearActivePotions()
    {
        super.clearActivePotions();
    }

    public final void superClearItemInUse()
    {
        super.clearItemInUse();
    }

    /**
     * close the current crafting gui
     */
    public void closeCraftingGui()
    {
        craftingInventory.onCraftGuiClosed(this);
        craftingInventory = inventorySlots;
    }

    /**
     * set current crafting inventory back to the 2x2 square
     */
    public void closeScreen()
    {
        playerNetServerHandler.sendPacket(new Packet101CloseWindow(craftingInventory.windowId));
        closeCraftingGui();
    }

    public final void superCloseScreen()
    {
        super.closeScreen();
    }

    public final void superCopyPlayer(EntityPlayer entityplayer)
    {
        super.copyPlayer(entityplayer);
    }

    public final void realDamageArmor(int i)
    {
        damageArmor(i);
    }

    public final void superDamageArmor(int i)
    {
        super.damageArmor(i);
    }

    public final void realDealFireDamage(int i)
    {
        dealFireDamage(i);
    }

    public final void superDealFireDamage(int i)
    {
        super.dealFireDamage(i);
    }

    public final int realDecreaseAirSupply(int i)
    {
        return decreaseAirSupply(i);
    }

    public final int superDecreaseAirSupply(int i)
    {
        return super.decreaseAirSupply(i);
    }

    public final void realDespawnEntity()
    {
        despawnEntity();
    }

    public final void superDespawnEntity()
    {
        super.despawnEntity();
    }

    public final void superDestroyCurrentEquippedItem()
    {
        super.destroyCurrentEquippedItem();
    }

    public final void superDetachHome()
    {
        super.detachHome();
    }

    /**
     * Displays the GUI for interacting with a brewing stand.
     */
    public void displayGUIBrewingStand(TileEntityBrewingStand par1TileEntityBrewingStand)
    {
        getNextWidowId();
        closeCraftingGui();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 5, par1TileEntityBrewingStand.getInvName(), par1TileEntityBrewingStand.getSizeInventory()));
        craftingInventory = new ContainerBrewingStand(inventory, par1TileEntityBrewingStand);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    public final void superDisplayGUIBrewingStand(TileEntityBrewingStand tileentitybrewingstand)
    {
        super.displayGUIBrewingStand(tileentitybrewingstand);
    }

    public final void superDisplayGUIEditSign(TileEntitySign tileentitysign)
    {
        super.displayGUIEditSign(tileentitysign);
    }

    public void displayGUIEnchantment(int par1, int par2, int par3)
    {
        getNextWidowId();
        closeCraftingGui();
        playerNetServerHandler.sendPacket(new Packet100OpenWindow(currentWindowId, 4, "Enchanting", 9));
        craftingInventory = new ContainerEnchantment(inventory, worldObj, par1, par2, par3);
        craftingInventory.windowId = currentWindowId;
        craftingInventory.onCraftGuiOpened(this);
    }

    public final void superDisplayGUIEnchantment(int i, int j, int k)
    {
        super.displayGUIEnchantment(i, j, k);
    }

    public final void realDropFewItems(boolean flag, int i)
    {
        dropFewItems(flag, i);
    }

    public final void superDropFewItems(boolean flag, int i)
    {
        super.dropFewItems(flag, i);
    }

    public final EntityItem superDropItem(int i, int j)
    {
        return super.dropItem(i, j);
    }

    public final EntityItem superDropItemWithOffset(int i, int j, float f)
    {
        return super.dropItemWithOffset(i, j, f);
    }

    public final EntityItem superDropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag)
    {
        return super.dropPlayerItemWithRandomChoice(itemstack, flag);
    }

    public final void realDropRareDrop(int i)
    {
        dropRareDrop(i);
    }

    public final void superDropRareDrop(int i)
    {
        super.dropRareDrop(i);
    }

    public final void superEatGrassBonus()
    {
        super.eatGrassBonus();
    }

    public final EntityItem superEntityDropItem(ItemStack itemstack, float f)
    {
        return super.entityDropItem(itemstack, f);
    }

    public final void realEntityInit()
    {
        entityInit();
    }

    public final void superEntityInit()
    {
        super.entityInit();
    }

    public final boolean superEquals(Object obj)
    {
        return super.equals(obj);
    }

    public final void superExtinguish()
    {
        super.extinguish();
    }

    public final void superFaceEntity(Entity entity, float f, float f1)
    {
        super.faceEntity(entity, f, f1);
    }

    public void func_20057_k()
    {
        craftingInventory.onCraftGuiOpened(this);
    }

    public void func_22068_s()
    {
    }

    public void func_28017_a(Container par1Container)
    {
        updateCraftingInventory(par1Container, par1Container.func_28127_b());
    }

    public void func_30001_B()
    {
        lastHealth = 0xfa0a1f01;
    }

    public void func_30002_A()
    {
        if (ridingEntity != null)
        {
            mountEntity(ridingEntity);
        }

        if (riddenByEntity != null)
        {
            riddenByEntity.interact(this);
        }

        if (sleeping)
        {
            wakeUpPlayer(true, false, false);
        }
    }

    public final float superFunc_48314_aq()
    {
        return super.func_48314_aq();
    }

    public final EntitySenses superFunc_48318_al()
    {
        return super.func_48318_al();
    }

    public final void superFunc_48320_d(float f)
    {
        super.func_48320_d(f);
    }

    public final float superFunc_48332_ar()
    {
        return super.func_48332_ar();
    }

    public final boolean superFunc_48336_a(Class class1)
    {
        return super.func_48336_a(class1);
    }

    public void func_50022_L()
    {
        if (playerNetServerHandler == null)
        {
            return;
        }
        else
        {
            playerNetServerHandler.sendPacket(new Packet202PlayerAbilities(capabilities));
            return;
        }
    }

    public final void superFunc_50022_L()
    {
        super.func_50022_L();
    }

    public final EntityLiving superGetAITarget()
    {
        return super.getAITarget();
    }

    public final PotionEffect superGetActivePotionEffect(Potion potion)
    {
        return super.getActivePotionEffect(potion);
    }

    public final Collection superGetActivePotionEffects()
    {
        return super.getActivePotionEffects();
    }

    public final int superGetAge()
    {
        return super.getAge();
    }

    public final int superGetAir()
    {
        return super.getAir();
    }

    public final EntityLiving superGetAttackTarget()
    {
        return super.getAttackTarget();
    }

    public final AxisAlignedBB superGetBoundingBox()
    {
        return super.getBoundingBox();
    }

    public final boolean superGetCanSpawnHere()
    {
        return super.getCanSpawnHere();
    }

    public final float superGetCollisionBorderSize()
    {
        return super.getCollisionBorderSize();
    }

    public final AxisAlignedBB superGetCollisionBox(Entity entity)
    {
        return super.getCollisionBox(entity);
    }

    public final EnumCreatureAttribute superGetCreatureAttribute()
    {
        return super.getCreatureAttribute();
    }

    public final ItemStack superGetCurrentEquippedItem()
    {
        return super.getCurrentEquippedItem();
    }

    public final DataWatcher superGetDataWatcher()
    {
        return super.getDataWatcher();
    }

    public final String realGetDeathSound()
    {
        return getDeathSound();
    }

    public final String superGetDeathSound()
    {
        return super.getDeathSound();
    }

    public final double superGetDistance(double d, double d1, double d2)
    {
        return super.getDistance(d, d1, d2);
    }

    public final double superGetDistanceSqToEntity(Entity entity)
    {
        return super.getDistanceSqToEntity(entity);
    }

    public final float superGetDistanceToEntity(Entity entity)
    {
        return super.getDistanceToEntity(entity);
    }

    public final int realGetDropItemId()
    {
        return getDropItemId();
    }

    public final int superGetDropItemId()
    {
        return super.getDropItemId();
    }

    /**
     * 0: Tool in Hand; 1-4: Armor
     */
    public ItemStack getEquipmentInSlot(int par1)
    {
        if (par1 == 0)
        {
            return inventory.getCurrentItem();
        }
        else
        {
            return inventory.armorInventory[par1 - 1];
        }
    }

    public final int realGetExperiencePoints(EntityPlayer entityplayer)
    {
        return getExperiencePoints(entityplayer);
    }

    public final int superGetExperiencePoints(EntityPlayer entityplayer)
    {
        return super.getExperiencePoints(entityplayer);
    }

    public final boolean realGetFlag(int i)
    {
        return getFlag(i);
    }

    public final boolean superGetFlag(int i)
    {
        return super.getFlag(i);
    }

    public final FoodStats superGetFoodStats()
    {
        return super.getFoodStats();
    }

    public final int superGetHealth()
    {
        return super.getHealth();
    }

    public final ChunkCoordinates superGetHomePosition()
    {
        return super.getHomePosition();
    }

    public final String realGetHurtSound()
    {
        return getHurtSound();
    }

    public final String superGetHurtSound()
    {
        return super.getHurtSound();
    }

    /**
     * returns the inventory of this entity (only used in EntityPlayerMP it seems)
     */
    public ItemStack[] getInventory()
    {
        return playerInventory;
    }

    public final ItemStack[] superGetInventory()
    {
        return super.getInventory();
    }

    public final EntityJumpHelper superGetJumpHelper()
    {
        return super.getJumpHelper();
    }

    public final EntityLiving superGetLastAttackingEntity()
    {
        return super.getLastAttackingEntity();
    }

    public final String realGetLivingSound()
    {
        return getLivingSound();
    }

    public final String superGetLivingSound()
    {
        return super.getLivingSound();
    }

    public final Vec3D superGetLook(float f)
    {
        return super.getLook(f);
    }

    public final EntityLookHelper superGetLookHelper()
    {
        return super.getLookHelper();
    }

    public final Vec3D superGetLookVec()
    {
        return super.getLookVec();
    }

    public final int superGetMaxHealth()
    {
        return super.getMaxHealth();
    }

    public final int superGetMaxSpawnedInChunk()
    {
        return super.getMaxSpawnedInChunk();
    }

    public final float superGetMaximumHomeDistance()
    {
        return super.getMaximumHomeDistance();
    }

    public final double superGetMountedYOffset()
    {
        return super.getMountedYOffset();
    }

    public final EntityMoveHelper superGetMoveHelper()
    {
        return super.getMoveHelper();
    }

    public final PathNavigate superGetNavigator()
    {
        return super.getNavigator();
    }

    /**
     * get the next window id to use
     */
    private void getNextWidowId()
    {
        currentWindowId = currentWindowId % 100 + 1;
    }

    public final void realGetNextWidowId()
    {
        getNextWidowId();
    }

    public final Entity[] superGetParts()
    {
        return super.getParts();
    }

    public final Random superGetRNG()
    {
        return super.getRNG();
    }

    public final float realGetSoundVolume()
    {
        return getSoundVolume();
    }

    public final float superGetSoundVolume()
    {
        return super.getSoundVolume();
    }

    public final ChunkCoordinates superGetSpawnChunk()
    {
        return super.getSpawnChunk();
    }

    public final float realGetSpeedModifier()
    {
        return getSpeedModifier();
    }

    public final float superGetSpeedModifier()
    {
        return super.getSpeedModifier();
    }

    public final int superGetTalkInterval()
    {
        return super.getTalkInterval();
    }

    /**
     * gets description packets from all TileEntity's that override func_20070
     */
    private void getTileEntityInfo(TileEntity par1TileEntity)
    {
        if (par1TileEntity != null)
        {
            Packet packet = par1TileEntity.getDescriptionPacket();

            if (packet != null)
            {
                playerNetServerHandler.sendPacket(packet);
            }
        }
    }

    public final void realGetTileEntityInfo(TileEntity tileentity)
    {
        getTileEntityInfo(tileentity);
    }

    public final int superGetTotalArmorValue()
    {
        return super.getTotalArmorValue();
    }

    public final String superGetUsername()
    {
        return super.getUsername();
    }

    public final int superGetVerticalFaceSpeed()
    {
        return super.getVerticalFaceSpeed();
    }

    public final double superGetYOffset()
    {
        return super.getYOffset();
    }

    /**
     * process player falling based on movement packet
     */
    public void handleFalling(double par1, boolean par3)
    {
        super.updateFallState(par1, par3);
    }

    public final boolean superHandleLavaMovement()
    {
        return super.handleLavaMovement();
    }

    public final boolean superHandleWaterMovement()
    {
        return super.handleWaterMovement();
    }

    public final boolean superHasHome()
    {
        return super.hasHome();
    }

    public final int superHashCode()
    {
        return super.hashCode();
    }

    public final boolean realIsAIEnabled()
    {
        return isAIEnabled();
    }

    public final boolean superIsAIEnabled()
    {
        return super.isAIEnabled();
    }

    public final boolean superIsBlocking()
    {
        return super.isBlocking();
    }

    public final boolean superIsBurning()
    {
        return super.isBurning();
    }

    public final boolean superIsChild()
    {
        return super.isChild();
    }

    public final boolean realIsClientWorld()
    {
        return isClientWorld();
    }

    public final boolean superIsClientWorld()
    {
        return super.isClientWorld();
    }

    public final boolean superIsEntityAlive()
    {
        return super.isEntityAlive();
    }

    public final boolean superIsEntityEqual(Entity entity)
    {
        return super.isEntityEqual(entity);
    }

    public final boolean superIsEntityUndead()
    {
        return super.isEntityUndead();
    }

    public final boolean realIsMovementBlocked()
    {
        return isMovementBlocked();
    }

    public final boolean superIsMovementBlocked()
    {
        return super.isMovementBlocked();
    }

    public final boolean superIsOffsetPositionInLiquid(double d, double d1, double d2)
    {
        return super.isOffsetPositionInLiquid(d, d1, d2);
    }

    /**
     * returns if pvp is enabled or not
     */
    protected boolean isPVPEnabled()
    {
        return mcServer.pvpOn;
    }

    public final boolean realIsPVPEnabled()
    {
        return isPVPEnabled();
    }

    public final boolean superIsPVPEnabled()
    {
        return super.isPVPEnabled();
    }

    public final boolean realIsPlayer()
    {
        return isPlayer();
    }

    public final boolean superIsPlayer()
    {
        return super.isPlayer();
    }

    public final boolean superIsPlayerFullyAsleep()
    {
        return super.isPlayerFullyAsleep();
    }

    public final boolean superIsPotionActive(Potion potion)
    {
        return super.isPotionActive(potion);
    }

    public final boolean superIsPotionApplicable(PotionEffect potioneffect)
    {
        return super.isPotionApplicable(potioneffect);
    }

    public final boolean superIsSneaking()
    {
        return super.isSneaking();
    }

    public final boolean superIsSprinting()
    {
        return super.isSprinting();
    }

    public final boolean superIsUsingItem()
    {
        return super.isUsingItem();
    }

    public final boolean superIsWet()
    {
        return super.isWet();
    }

    public final boolean superIsWithinHomeDistance(int i, int j, int k)
    {
        return super.isWithinHomeDistance(i, j, k);
    }

    public final boolean superIsWithinHomeDistanceCurrentPosition()
    {
        return super.isWithinHomeDistanceCurrentPosition();
    }

    public final void realJoinEntityItemWithWorld(EntityItem entityitem)
    {
        joinEntityItemWithWorld(entityitem);
    }

    public final void superJoinEntityItemWithWorld(EntityItem entityitem)
    {
        super.joinEntityItemWithWorld(entityitem);
    }

    public final void realKill()
    {
        kill();
    }

    public final void superKill()
    {
        super.kill();
    }

    public final void superKnockBack(Entity entity, int i, double d, double d1)
    {
        super.knockBack(entity, i, d, d1);
    }

    /**
     * Called when a player mounts an entity. e.g. mounts a pig, mounts a boat.
     */
    public void mountEntity(Entity par1Entity)
    {
        super.mountEntity(par1Entity);
        playerNetServerHandler.sendPacket(new Packet39AttachEntity(this, ridingEntity));
        playerNetServerHandler.teleportTo(posX, posY, posZ, rotationYaw, rotationPitch);
    }

    public final void superMountEntity(Entity entity)
    {
        super.mountEntity(entity);
    }

    public final NBTTagList realNewDoubleNBTList(double ad[])
    {
        return newDoubleNBTList(ad);
    }

    public final NBTTagList superNewDoubleNBTList(double ad[])
    {
        return super.newDoubleNBTList(ad);
    }

    public final NBTTagList realNewFloatNBTList(float af[])
    {
        return newFloatNBTList(af);
    }

    public final NBTTagList superNewFloatNBTList(float af[])
    {
        return super.newFloatNBTList(af);
    }

    protected void onChangedPotionEffect(PotionEffect par1PotionEffect)
    {
        super.onChangedPotionEffect(par1PotionEffect);
        playerNetServerHandler.sendPacket(new Packet41EntityEffect(entityId, par1PotionEffect));
    }

    public final void realOnChangedPotionEffect(PotionEffect potioneffect)
    {
        onChangedPotionEffect(potioneffect);
    }

    public final void superOnChangedPotionEffect(PotionEffect potioneffect)
    {
        super.onChangedPotionEffect(potioneffect);
    }

    public final void superOnCollideWithPlayer(EntityPlayer entityplayer)
    {
        super.onCollideWithPlayer(entityplayer);
    }

    /**
     * Called when the player performs a critical hit on the Entity. Args: entity that was hit critically
     */
    public void onCriticalHit(Entity par1Entity)
    {
        EntityTracker entitytracker = mcServer.getEntityTracker(dimension);
        entitytracker.sendPacketToTrackedPlayersAndTrackedEntity(this, new Packet18Animation(par1Entity, 6));
    }

    public final void superOnCriticalHit(Entity entity)
    {
        super.onCriticalHit(entity);
    }

    public final void realOnDeathUpdate()
    {
        onDeathUpdate();
    }

    public final void superOnDeathUpdate()
    {
        super.onDeathUpdate();
    }

    public void onEnchantmentCritical(Entity par1Entity)
    {
        EntityTracker entitytracker = mcServer.getEntityTracker(dimension);
        entitytracker.sendPacketToTrackedPlayersAndTrackedEntity(this, new Packet18Animation(par1Entity, 7));
    }

    public final void superOnEnchantmentCritical(Entity entity)
    {
        super.onEnchantmentCritical(entity);
    }

    public final void superOnEntityDeath()
    {
        super.onEntityDeath();
    }

    public final void superOnEntityUpdate()
    {
        super.onEntityUpdate();
    }

    protected void onFinishedPotionEffect(PotionEffect par1PotionEffect)
    {
        super.onFinishedPotionEffect(par1PotionEffect);
        playerNetServerHandler.sendPacket(new Packet42RemoveEntityEffect(entityId, par1PotionEffect));
    }

    public final void realOnFinishedPotionEffect(PotionEffect potioneffect)
    {
        onFinishedPotionEffect(potioneffect);
    }

    public final void superOnFinishedPotionEffect(PotionEffect potioneffect)
    {
        super.onFinishedPotionEffect(potioneffect);
    }

    /**
     * Called whenever an item is picked up from walking over it. Args: pickedUpEntity, stackSize
     */
    public void onItemPickup(Entity par1Entity, int par2)
    {
        if (!par1Entity.isDead)
        {
            EntityTracker entitytracker = mcServer.getEntityTracker(dimension);

            if (par1Entity instanceof EntityItem)
            {
                entitytracker.sendPacketToTrackedPlayers(par1Entity, new Packet22Collect(par1Entity.entityId, entityId));
            }

            if (par1Entity instanceof EntityArrow)
            {
                entitytracker.sendPacketToTrackedPlayers(par1Entity, new Packet22Collect(par1Entity.entityId, entityId));
            }

            if (par1Entity instanceof EntityXPOrb)
            {
                entitytracker.sendPacketToTrackedPlayers(par1Entity, new Packet22Collect(par1Entity.entityId, entityId));
            }
        }

        super.onItemPickup(par1Entity, par2);
        craftingInventory.updateCraftingResults();
    }

    public final void superOnItemPickup(Entity entity, int i)
    {
        super.onItemPickup(entity, i);
    }

    public void onItemStackChanged(ItemStack itemstack)
    {
    }

    public final void superOnItemStackChanged(ItemStack itemstack)
    {
        super.onItemStackChanged(itemstack);
    }

    /**
     * Used for when item use count runs out, ie: eating completed
     */
    protected void onItemUseFinish()
    {
        playerNetServerHandler.sendPacket(new Packet38EntityStatus(entityId, (byte)9));
        super.onItemUseFinish();
    }

    public final void realOnItemUseFinish()
    {
        onItemUseFinish();
    }

    public final void superOnItemUseFinish()
    {
        super.onItemUseFinish();
    }

    protected void onNewPotionEffect(PotionEffect par1PotionEffect)
    {
        super.onNewPotionEffect(par1PotionEffect);
        playerNetServerHandler.sendPacket(new Packet41EntityEffect(entityId, par1PotionEffect));
    }

    public final void realOnNewPotionEffect(PotionEffect potioneffect)
    {
        onNewPotionEffect(potioneffect);
    }

    public final void superOnNewPotionEffect(PotionEffect potioneffect)
    {
        super.onNewPotionEffect(potioneffect);
    }

    public final void superOnStruckByLightning(EntityLightningBolt entitylightningbolt)
    {
        super.onStruckByLightning(entitylightningbolt);
    }

    public final void superPlayLivingSound()
    {
        super.playLivingSound();
    }

    public final void realPlayStepSound(int i, int j, int k, int l)
    {
        playStepSound(i, j, k, l);
    }

    public final void superPlayStepSound(int i, int j, int k, int l)
    {
        super.playStepSound(i, j, k, l);
    }

    public final boolean realPushOutOfBlocks(double d, double d1, double d2)
    {
        return pushOutOfBlocks(d, d1, d2);
    }

    public final boolean superPushOutOfBlocks(double d, double d1, double d2)
    {
        return super.pushOutOfBlocks(d, d1, d2);
    }

    public final void superReadFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
    }

    /**
     * Removes the specified number of experience levels.
     */
    public void removeExperience(int par1)
    {
        super.removeExperience(par1);
        lastExperience = -1;
    }

    public final void superRemoveExperience(int i)
    {
        super.removeExperience(i);
    }

    public final void superRenderBrokenItemStack(ItemStack itemstack)
    {
        super.renderBrokenItemStack(itemstack);
    }

    /**
     * sets the players height back to normal after doing things like sleeping and dieing
     */
    protected void resetHeight()
    {
        yOffset = 0.0F;
    }

    public final void realResetHeight()
    {
        resetHeight();
    }

    public final void superResetHeight()
    {
        super.resetHeight();
    }

    public final void superSetAir(int i)
    {
        super.setAir(i);
    }

    public final void superSetAttackTarget(EntityLiving entityliving)
    {
        super.setAttackTarget(entityliving);
    }

    public final void realSetBeenAttacked()
    {
        setBeenAttacked();
    }

    public final void superSetBeenAttacked()
    {
        super.setBeenAttacked();
    }

    public final void superSetEating(boolean flag)
    {
        super.setEating(flag);
    }

    public final void superSetEntityHealth(int i)
    {
        super.setEntityHealth(i);
    }

    public final void superSetFire(int i)
    {
        super.setFire(i);
    }

    public final void realSetFlag(int i, boolean flag)
    {
        setFlag(i, flag);
    }

    public final void superSetFlag(int i, boolean flag)
    {
        super.setFlag(i, flag);
    }

    public final void superSetHomeArea(int i, int j, int k, int l)
    {
        super.setHomeArea(i, j, k, l);
    }

    public final void superSetInPortal()
    {
        super.setInPortal();
    }

    public final void superSetInWeb()
    {
        super.setInWeb();
    }

    /**
     * sets the itemInUse when the use item button is clicked. Args: itemstack, int maxItemUseDuration
     */
    public void setItemInUse(ItemStack par1ItemStack, int par2)
    {
        super.setItemInUse(par1ItemStack, par2);

        if (par1ItemStack != null && par1ItemStack.getItem() != null && par1ItemStack.getItem().getItemUseAction(par1ItemStack) == EnumAction.eat)
        {
            EntityTracker entitytracker = mcServer.getEntityTracker(dimension);
            entitytracker.sendPacketToTrackedPlayersAndTrackedEntity(this, new Packet18Animation(this, 5));
        }
    }

    public final void superSetItemInUse(ItemStack itemstack, int i)
    {
        super.setItemInUse(itemstack, i);
    }

    public final void superSetJumping(boolean flag)
    {
        super.setJumping(flag);
    }

    public final void superSetLastAttackingEntity(Entity entity)
    {
        super.setLastAttackingEntity(entity);
    }

    public final void superSetLocationAndAngles(double d, double d1, double d2, float f, float f1)
    {
        super.setLocationAndAngles(d, d1, d2, f, f1);
    }

    public final void superSetMoveForward(float f)
    {
        super.setMoveForward(f);
    }

    public final void realSetOnFireFromLava()
    {
        setOnFireFromLava();
    }

    public final void superSetOnFireFromLava()
    {
        super.setOnFireFromLava();
    }

    public final void superSetPositionAndRotation(double d, double d1, double d2, float f, float f1)
    {
        super.setPositionAndRotation(d, d1, d2, f, f1);
    }

    /**
     * Sets the position of the entity and updates the 'last' variables
     */
    public void setPositionAndUpdate(double par1, double par3, double par5)
    {
        playerNetServerHandler.teleportTo(par1, par3, par5, rotationYaw, rotationPitch);
    }

    public final void superSetPositionAndUpdate(double d, double d1, double d2)
    {
        super.setPositionAndUpdate(d, d1, d2);
    }

    public final void superSetRevengeTarget(EntityLiving entityliving)
    {
        super.setRevengeTarget(entityliving);
    }

    public final void realSetRotation(float f, float f1)
    {
        setRotation(f, f1);
    }

    public final void superSetRotation(float f, float f1)
    {
        super.setRotation(f, f1);
    }

    public final void realSetSize(float f, float f1)
    {
        setSize(f, f1);
    }

    public final void superSetSize(float f, float f1)
    {
        super.setSize(f, f1);
    }

    public final void superSetSneaking(boolean flag)
    {
        super.setSneaking(flag);
    }

    public final void superSetSpawnChunk(ChunkCoordinates chunkcoordinates)
    {
        super.setSpawnChunk(chunkcoordinates);
    }

    public final void superSetSprinting(boolean flag)
    {
        super.setSprinting(flag);
    }

    /**
     * Sets the reference to the World object.
     */
    public void setWorld(World par1World)
    {
        super.setWorld(par1World);
    }

    public final void superSetWorld(World world)
    {
        super.setWorld(world);
    }

    public final boolean superShouldHeal()
    {
        return super.shouldHeal();
    }

    /**
     * puts player to sleep on specified bed if possible
     */
    public EnumStatus sleepInBedAt(int par1, int par2, int par3)
    {
        EnumStatus enumstatus = super.sleepInBedAt(par1, par2, par3);

        if (enumstatus == EnumStatus.OK)
        {
            EntityTracker entitytracker = mcServer.getEntityTracker(dimension);
            Packet17Sleep packet17sleep = new Packet17Sleep(this, 0, par1, par2, par3);
            entitytracker.sendPacketToTrackedPlayers(this, packet17sleep);
            playerNetServerHandler.teleportTo(posX, posY, posZ, rotationYaw, rotationPitch);
            playerNetServerHandler.sendPacket(packet17sleep);
        }

        return enumstatus;
    }

    public final EnumStatus superSleepInBedAt(int i, int j, int k)
    {
        return super.sleepInBedAt(i, j, k);
    }

    public final void superSpawnExplosionParticle()
    {
        super.spawnExplosionParticle();
    }

    public final void superStopUsingItem()
    {
        super.stopUsingItem();
    }

    /**
     * Swings the item the player is holding.
     */
    public void swingItem()
    {
        if (!isSwinging)
        {
            swingProgressInt = -1;
            isSwinging = true;
            EntityTracker entitytracker = mcServer.getEntityTracker(dimension);
            entitytracker.sendPacketToTrackedPlayers(this, new Packet18Animation(this, 1));
        }
    }

    public final void superSwingItem()
    {
        super.swingItem();
    }

    public void travelToTheEnd(int par1)
    {
        if (dimension == 1 && par1 == 1)
        {
            triggerAchievement(AchievementList.theEnd2);
            worldObj.setEntityDead(this);
            gameOver = true;
            playerNetServerHandler.sendPacket(new Packet70Bed(4, 0));
        }
        else
        {
            triggerAchievement(AchievementList.theEnd);
            ChunkCoordinates chunkcoordinates = mcServer.getWorldManager(par1).getEntrancePortalLocation();

            if (chunkcoordinates != null)
            {
                playerNetServerHandler.teleportTo(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, 0.0F, 0.0F);
            }

            mcServer.configManager.sendPlayerToOtherDimension(this, 1);
            lastExperience = -1;
            lastHealth = -1;
            field_35221_cc = -1;
        }
    }

    public final void superTravelToTheEnd(int i)
    {
        super.travelToTheEnd(i);
    }

    public final void superTriggerAchievement(StatBase statbase)
    {
        super.triggerAchievement(statbase);
    }

    public final void realUpdateAITasks()
    {
        updateAITasks();
    }

    public final void superUpdateAITasks()
    {
        super.updateAITasks();
    }

    public final void realUpdateAITick()
    {
        updateAITick();
    }

    public final void superUpdateAITick()
    {
        super.updateAITick();
    }

    /**
     * update the crafting window inventory with the items in the list
     */
    public void updateCraftingInventory(Container par1Container, List par2List)
    {
        playerNetServerHandler.sendPacket(new Packet104WindowItems(par1Container.windowId, par2List));
        playerNetServerHandler.sendPacket(new Packet103SetSlot(-1, -1, inventory.getItemStack()));
    }

    /**
     * send information about the crafting inventory to the client(currently only for furnace times)
     */
    public void updateCraftingInventoryInfo(Container par1Container, int par2, int par3)
    {
        playerNetServerHandler.sendPacket(new Packet105UpdateProgressbar(par1Container.windowId, par2, par3));
    }

    /**
     * inform the player of a change in a single slot
     */
    public void updateCraftingInventorySlot(Container par1Container, int par2, ItemStack par3ItemStack)
    {
        if (par1Container.getSlot(par2) instanceof SlotCrafting)
        {
            return;
        }

        if (isChangingQuantityOnly)
        {
            return;
        }
        else
        {
            playerNetServerHandler.sendPacket(new Packet103SetSlot(par1Container.windowId, par2, par3ItemStack));
            return;
        }
    }

    /**
     * Takes in the distance the entity has fallen this tick and whether its on the ground to update the fall distance
     * and deal fall damage if landing on the ground.  Args: distanceFallenThisTick, onGround
     */
    protected void updateFallState(double d, boolean flag)
    {
    }

    public final void realUpdateFallState(double d, boolean flag)
    {
        updateFallState(d, flag);
    }

    public final void superUpdateFallState(double d, boolean flag)
    {
        super.updateFallState(d, flag);
    }

    /**
     * updates item held by mouse, This method always returns before doing anything...
     */
    public void updateHeldItem()
    {
        if (isChangingQuantityOnly)
        {
            return;
        }
        else
        {
            playerNetServerHandler.sendPacket(new Packet103SetSlot(-1, -1, inventory.getItemStack()));
            return;
        }
    }

    public final void realUpdateItemUse(ItemStack itemstack, int i)
    {
        updateItemUse(itemstack, i);
    }

    public final void superUpdateItemUse(ItemStack itemstack, int i)
    {
        super.updateItemUse(itemstack, i);
    }

    public final void realUpdatePotionEffects()
    {
        updatePotionEffects();
    }

    public final void superUpdatePotionEffects()
    {
        super.updatePotionEffects();
    }

    public final void superUpdateRidden()
    {
        super.updateRidden();
    }

    public final void superUpdateRiderPosition()
    {
        super.updateRiderPosition();
    }

    public final void superUseCurrentItemOnEntity(Entity entity)
    {
        super.useCurrentItemOnEntity(entity);
    }

    /**
     * Wake up the player if they're sleeping.
     */
    public void wakeUpPlayer(boolean par1, boolean par2, boolean par3)
    {
        if (isPlayerSleeping())
        {
            EntityTracker entitytracker = mcServer.getEntityTracker(dimension);
            entitytracker.sendPacketToTrackedPlayersAndTrackedEntity(this, new Packet18Animation(this, 3));
        }

        super.wakeUpPlayer(par1, par2, par3);

        if (playerNetServerHandler != null)
        {
            playerNetServerHandler.teleportTo(posX, posY, posZ, rotationYaw, rotationPitch);
        }
    }

    public final void superWakeUpPlayer(boolean flag, boolean flag1, boolean flag2)
    {
        super.wakeUpPlayer(flag, flag1, flag2);
    }

    public final void superWriteToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
    }

    public final int superXpBarCap()
    {
        return super.xpBarCap();
    }

    public final HashMap getActivePotionsMapField()
    {
        return activePotionsMap;
    }

    public final void setActivePotionsMapField(HashMap hashmap)
    {
        activePotionsMap = hashmap;
    }

    public final EntityPlayer getAttackingPlayerField()
    {
        return attackingPlayer;
    }

    public final void setAttackingPlayerField(EntityPlayer entityplayer)
    {
        attackingPlayer = entityplayer;
    }

    public final int getCarryoverDamageField()
    {
        return carryoverDamage;
    }

    public final void setCarryoverDamageField(int i)
    {
        carryoverDamage = i;
    }

    public final int getCurrentWindowIdField()
    {
        return currentWindowId;
    }

    public final void setCurrentWindowIdField(int i)
    {
        currentWindowId = i;
    }

    public final DataWatcher getDataWatcherField()
    {
        return dataWatcher;
    }

    public final void setDataWatcherField(DataWatcher datawatcher)
    {
        dataWatcher = datawatcher;
    }

    public final boolean getDeadField()
    {
        return dead;
    }

    public final void setDeadField(boolean flag)
    {
        dead = flag;
    }

    public final float getDefaultPitchField()
    {
        return defaultPitch;
    }

    public final void setDefaultPitchField(float f)
    {
        defaultPitch = f;
    }

    public final int getEntityAgeField()
    {
        return entityAge;
    }

    public final void setEntityAgeField(int i)
    {
        entityAge = i;
    }

    public final String getEntityTypeField()
    {
        return entityType;
    }

    public final void setEntityTypeField(String s)
    {
        entityType = s;
    }

    public final int getExperienceValueField()
    {
        return experienceValue;
    }

    public final void setExperienceValueField(int i)
    {
        experienceValue = i;
    }

    public final int getField_35221_ccField()
    {
        return field_35221_cc;
    }

    public final void setField_35221_ccField(int i)
    {
        field_35221_cc = i;
    }

    public final boolean getField_35222_cdField()
    {
        return field_35222_cd;
    }

    public final void setField_35222_cdField(boolean flag)
    {
        field_35222_cd = flag;
    }

    public final float getField_9113_aMField()
    {
        return field_9113_aM;
    }

    public final void setField_9113_aMField(float f)
    {
        field_9113_aM = f;
    }

    public final float getField_9115_aKField()
    {
        return field_9115_aK;
    }

    public final void setField_9115_aKField(float f)
    {
        field_9115_aK = f;
    }

    public final float getField_9117_aIField()
    {
        return field_9117_aI;
    }

    public final void setField_9117_aIField(float f)
    {
        field_9117_aI = f;
    }

    public final boolean getField_9118_aHField()
    {
        return field_9118_aH;
    }

    public final void setField_9118_aHField(boolean flag)
    {
        field_9118_aH = flag;
    }

    public final boolean getField_9120_aFField()
    {
        return field_9120_aF;
    }

    public final void setField_9120_aFField(boolean flag)
    {
        field_9120_aF = flag;
    }

    public final float getField_9121_aEField()
    {
        return field_9121_aE;
    }

    public final void setField_9121_aEField(float f)
    {
        field_9121_aE = f;
    }

    public final float getField_9122_aDField()
    {
        return field_9122_aD;
    }

    public final void setField_9122_aDField(float f)
    {
        field_9122_aD = f;
    }

    public final float getField_9123_aCField()
    {
        return field_9123_aC;
    }

    public final void setField_9123_aCField(float f)
    {
        field_9123_aC = f;
    }

    public final float getField_9124_aBField()
    {
        return field_9124_aB;
    }

    public final void setField_9124_aBField(float f)
    {
        field_9124_aB = f;
    }

    public final float getField_9134_blField()
    {
        return field_9134_bl;
    }

    public final void setField_9134_blField(float f)
    {
        field_9134_bl = f;
    }

    public final int getFlyToggleTimerField()
    {
        return flyToggleTimer;
    }

    public final void setFlyToggleTimerField(int i)
    {
        flyToggleTimer = i;
    }

    public final FoodStats getFoodStatsField()
    {
        return foodStats;
    }

    public final void setFoodStatsField(FoodStats foodstats)
    {
        foodStats = foodstats;
    }

    public final int getHealthField()
    {
        return health;
    }

    public final void setHealthField(int i)
    {
        health = i;
    }

    public final boolean getInPortalField()
    {
        return inPortal;
    }

    public final void setInPortalField(boolean flag)
    {
        inPortal = flag;
    }

    public final boolean getInWaterField()
    {
        return inWater;
    }

    public final void setInWaterField(boolean flag)
    {
        inWater = flag;
    }

    public final boolean getIsImmuneToFireField()
    {
        return isImmuneToFire;
    }

    public final void setIsImmuneToFireField(boolean flag)
    {
        isImmuneToFire = flag;
    }

    public final boolean getIsInWebField()
    {
        return isInWeb;
    }

    public final void setIsInWebField(boolean flag)
    {
        isInWeb = flag;
    }

    public final boolean getIsJumpingField()
    {
        return isJumping;
    }

    public final void setIsJumpingField(boolean flag)
    {
        isJumping = flag;
    }

    public final int getLastExperienceField()
    {
        return lastExperience;
    }

    public final void setLastExperienceField(int i)
    {
        lastExperience = i;
    }

    public final int getLastHealthField()
    {
        return lastHealth;
    }

    public final void setLastHealthField(int i)
    {
        lastHealth = i;
    }

    public final float getMoveForwardField()
    {
        return moveForward;
    }

    public final void setMoveForwardField(float f)
    {
        moveForward = f;
    }

    public final float getMoveSpeedField()
    {
        return moveSpeed;
    }

    public final void setMoveSpeedField(float f)
    {
        moveSpeed = f;
    }

    public final float getMoveStrafingField()
    {
        return moveStrafing;
    }

    public final void setMoveStrafingField(float f)
    {
        moveStrafing = f;
    }

    public final int getNaturalArmorRatingField()
    {
        return naturalArmorRating;
    }

    public final void setNaturalArmorRatingField(int i)
    {
        naturalArmorRating = i;
    }

    public final int getNewPosRotationIncrementsField()
    {
        return newPosRotationIncrements;
    }

    public final void setNewPosRotationIncrementsField(int i)
    {
        newPosRotationIncrements = i;
    }

    public final double getNewPosXField()
    {
        return newPosX;
    }

    public final void setNewPosXField(double d)
    {
        newPosX = d;
    }

    public final double getNewPosYField()
    {
        return newPosY;
    }

    public final void setNewPosYField(double d)
    {
        newPosY = d;
    }

    public final double getNewPosZField()
    {
        return newPosZ;
    }

    public final void setNewPosZField(double d)
    {
        newPosZ = d;
    }

    public final double getNewRotationPitchField()
    {
        return newRotationPitch;
    }

    public final void setNewRotationPitchField(double d)
    {
        newRotationPitch = d;
    }

    public final double getNewRotationYawField()
    {
        return newRotationYaw;
    }

    public final void setNewRotationYawField(double d)
    {
        newRotationYaw = d;
    }

    public final int getNumTicksToChaseTargetField()
    {
        return numTicksToChaseTarget;
    }

    public final void setNumTicksToChaseTargetField(int i)
    {
        numTicksToChaseTarget = i;
    }

    public final ItemStack[] getPlayerInventoryField()
    {
        return playerInventory;
    }

    public final void setPlayerInventoryField(ItemStack aitemstack[])
    {
        playerInventory = aitemstack;
    }

    public final Random getRandField()
    {
        return rand;
    }

    public final void setRandField(Random random)
    {
        rand = random;
    }

    public final float getRandomYawVelocityField()
    {
        return randomYawVelocity;
    }

    public final void setRandomYawVelocityField(float f)
    {
        randomYawVelocity = f;
    }

    public final int getRecentlyHitField()
    {
        return recentlyHit;
    }

    public final void setRecentlyHitField(int i)
    {
        recentlyHit = i;
    }

    public final int getScoreValueField()
    {
        return scoreValue;
    }

    public final void setScoreValueField(int i)
    {
        scoreValue = i;
    }

    public final boolean getSleepingField()
    {
        return sleeping;
    }

    public final void setSleepingField(boolean flag)
    {
        sleeping = flag;
    }

    public final float getSpeedInAirField()
    {
        return speedInAir;
    }

    public final void setSpeedInAirField(float f)
    {
        speedInAir = f;
    }

    public final float getSpeedOnGroundField()
    {
        return speedOnGround;
    }

    public final void setSpeedOnGroundField(float f)
    {
        speedOnGround = f;
    }

    public final EntityAITasks getTargetTasksField()
    {
        return targetTasks;
    }

    public final void setTargetTasksField(EntityAITasks entityaitasks)
    {
        targetTasks = entityaitasks;
    }

    public final EntityAITasks getTasksField()
    {
        return tasks;
    }

    public final void setTasksField(EntityAITasks entityaitasks)
    {
        tasks = entityaitasks;
    }

    public final String getTextureField()
    {
        return texture;
    }

    public final void setTextureField(String s)
    {
        texture = s;
    }

    public final int getTicksOfInvulnField()
    {
        return ticksOfInvuln;
    }

    public final void setTicksOfInvulnField(int i)
    {
        ticksOfInvuln = i;
    }
}
