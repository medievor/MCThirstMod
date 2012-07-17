package net.minecraft.src;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public final class PlayerAPI
{
    private static final Class Class[];
    private static final Class Classes[];
    private static boolean isCreated;
    private static final Logger logger = Logger.getLogger("PlayerAPI");
    private static final List beforeAttackEntityFromHookTypes = new LinkedList();
    private static final List overrideAttackEntityFromHookTypes = new LinkedList();
    private static final List afterAttackEntityFromHookTypes = new LinkedList();
    private final PlayerBase beforeAttackEntityFromHooks[];
    private final PlayerBase overrideAttackEntityFromHooks[];
    private final PlayerBase afterAttackEntityFromHooks[];
    protected final boolean isAttackEntityFromModded;
    private static final List beforeAttackTargetEntityWithCurrentItemHookTypes = new LinkedList();
    private static final List overrideAttackTargetEntityWithCurrentItemHookTypes = new LinkedList();
    private static final List afterAttackTargetEntityWithCurrentItemHookTypes = new LinkedList();
    private final PlayerBase beforeAttackTargetEntityWithCurrentItemHooks[];
    private final PlayerBase overrideAttackTargetEntityWithCurrentItemHooks[];
    private final PlayerBase afterAttackTargetEntityWithCurrentItemHooks[];
    protected final boolean isAttackTargetEntityWithCurrentItemModded;
    private static final List beforeCanHarvestBlockHookTypes = new LinkedList();
    private static final List overrideCanHarvestBlockHookTypes = new LinkedList();
    private static final List afterCanHarvestBlockHookTypes = new LinkedList();
    private final PlayerBase beforeCanHarvestBlockHooks[];
    private final PlayerBase overrideCanHarvestBlockHooks[];
    private final PlayerBase afterCanHarvestBlockHooks[];
    protected final boolean isCanHarvestBlockModded;
    private static final List beforeCanPlayerEditHookTypes = new LinkedList();
    private static final List overrideCanPlayerEditHookTypes = new LinkedList();
    private static final List afterCanPlayerEditHookTypes = new LinkedList();
    private final PlayerBase beforeCanPlayerEditHooks[];
    private final PlayerBase overrideCanPlayerEditHooks[];
    private final PlayerBase afterCanPlayerEditHooks[];
    protected final boolean isCanPlayerEditModded;
    private static final List beforeCanTriggerWalkingHookTypes = new LinkedList();
    private static final List overrideCanTriggerWalkingHookTypes = new LinkedList();
    private static final List afterCanTriggerWalkingHookTypes = new LinkedList();
    private final PlayerBase beforeCanTriggerWalkingHooks[];
    private final PlayerBase overrideCanTriggerWalkingHooks[];
    private final PlayerBase afterCanTriggerWalkingHooks[];
    protected final boolean isCanTriggerWalkingModded;
    private static final List beforeDamageEntityHookTypes = new LinkedList();
    private static final List overrideDamageEntityHookTypes = new LinkedList();
    private static final List afterDamageEntityHookTypes = new LinkedList();
    private final PlayerBase beforeDamageEntityHooks[];
    private final PlayerBase overrideDamageEntityHooks[];
    private final PlayerBase afterDamageEntityHooks[];
    protected final boolean isDamageEntityModded;
    private static final List beforeDisplayGUIChestHookTypes = new LinkedList();
    private static final List overrideDisplayGUIChestHookTypes = new LinkedList();
    private static final List afterDisplayGUIChestHookTypes = new LinkedList();
    private final PlayerBase beforeDisplayGUIChestHooks[];
    private final PlayerBase overrideDisplayGUIChestHooks[];
    private final PlayerBase afterDisplayGUIChestHooks[];
    protected final boolean isDisplayGUIChestModded;
    private static final List beforeDisplayGUIDispenserHookTypes = new LinkedList();
    private static final List overrideDisplayGUIDispenserHookTypes = new LinkedList();
    private static final List afterDisplayGUIDispenserHookTypes = new LinkedList();
    private final PlayerBase beforeDisplayGUIDispenserHooks[];
    private final PlayerBase overrideDisplayGUIDispenserHooks[];
    private final PlayerBase afterDisplayGUIDispenserHooks[];
    protected final boolean isDisplayGUIDispenserModded;
    private static final List beforeDisplayGUIFurnaceHookTypes = new LinkedList();
    private static final List overrideDisplayGUIFurnaceHookTypes = new LinkedList();
    private static final List afterDisplayGUIFurnaceHookTypes = new LinkedList();
    private final PlayerBase beforeDisplayGUIFurnaceHooks[];
    private final PlayerBase overrideDisplayGUIFurnaceHooks[];
    private final PlayerBase afterDisplayGUIFurnaceHooks[];
    protected final boolean isDisplayGUIFurnaceModded;
    private static final List beforeDisplayWorkbenchGUIHookTypes = new LinkedList();
    private static final List overrideDisplayWorkbenchGUIHookTypes = new LinkedList();
    private static final List afterDisplayWorkbenchGUIHookTypes = new LinkedList();
    private final PlayerBase beforeDisplayWorkbenchGUIHooks[];
    private final PlayerBase overrideDisplayWorkbenchGUIHooks[];
    private final PlayerBase afterDisplayWorkbenchGUIHooks[];
    protected final boolean isDisplayWorkbenchGUIModded;
    private static final List beforeDropOneItemHookTypes = new LinkedList();
    private static final List overrideDropOneItemHookTypes = new LinkedList();
    private static final List afterDropOneItemHookTypes = new LinkedList();
    private final PlayerBase beforeDropOneItemHooks[];
    private final PlayerBase overrideDropOneItemHooks[];
    private final PlayerBase afterDropOneItemHooks[];
    protected final boolean isDropOneItemModded;
    private static final List beforeDropPlayerItemHookTypes = new LinkedList();
    private static final List overrideDropPlayerItemHookTypes = new LinkedList();
    private static final List afterDropPlayerItemHookTypes = new LinkedList();
    private final PlayerBase beforeDropPlayerItemHooks[];
    private final PlayerBase overrideDropPlayerItemHooks[];
    private final PlayerBase afterDropPlayerItemHooks[];
    protected final boolean isDropPlayerItemModded;
    private static final List beforeFallHookTypes = new LinkedList();
    private static final List overrideFallHookTypes = new LinkedList();
    private static final List afterFallHookTypes = new LinkedList();
    private final PlayerBase beforeFallHooks[];
    private final PlayerBase overrideFallHooks[];
    private final PlayerBase afterFallHooks[];
    protected final boolean isFallModded;
    private static final List beforeGetCurrentPlayerStrVsBlockHookTypes = new LinkedList();
    private static final List overrideGetCurrentPlayerStrVsBlockHookTypes = new LinkedList();
    private static final List afterGetCurrentPlayerStrVsBlockHookTypes = new LinkedList();
    private final PlayerBase beforeGetCurrentPlayerStrVsBlockHooks[];
    private final PlayerBase overrideGetCurrentPlayerStrVsBlockHooks[];
    private final PlayerBase afterGetCurrentPlayerStrVsBlockHooks[];
    protected final boolean isGetCurrentPlayerStrVsBlockModded;
    private static final List beforeGetDistanceSqHookTypes = new LinkedList();
    private static final List overrideGetDistanceSqHookTypes = new LinkedList();
    private static final List afterGetDistanceSqHookTypes = new LinkedList();
    private final PlayerBase beforeGetDistanceSqHooks[];
    private final PlayerBase overrideGetDistanceSqHooks[];
    private final PlayerBase afterGetDistanceSqHooks[];
    protected final boolean isGetDistanceSqModded;
    private static final List beforeGetBrightnessHookTypes = new LinkedList();
    private static final List overrideGetBrightnessHookTypes = new LinkedList();
    private static final List afterGetBrightnessHookTypes = new LinkedList();
    private final PlayerBase beforeGetBrightnessHooks[];
    private final PlayerBase overrideGetBrightnessHooks[];
    private final PlayerBase afterGetBrightnessHooks[];
    protected final boolean isGetBrightnessModded;
    private static final List beforeGetEyeHeightHookTypes = new LinkedList();
    private static final List overrideGetEyeHeightHookTypes = new LinkedList();
    private static final List afterGetEyeHeightHookTypes = new LinkedList();
    private final PlayerBase beforeGetEyeHeightHooks[];
    private final PlayerBase overrideGetEyeHeightHooks[];
    private final PlayerBase afterGetEyeHeightHooks[];
    protected final boolean isGetEyeHeightModded;
    private static final List beforeHealHookTypes = new LinkedList();
    private static final List overrideHealHookTypes = new LinkedList();
    private static final List afterHealHookTypes = new LinkedList();
    private final PlayerBase beforeHealHooks[];
    private final PlayerBase overrideHealHooks[];
    private final PlayerBase afterHealHooks[];
    protected final boolean isHealModded;
    private static final List beforeInteractHookTypes = new LinkedList();
    private static final List overrideInteractHookTypes = new LinkedList();
    private static final List afterInteractHookTypes = new LinkedList();
    private final PlayerBase beforeInteractHooks[];
    private final PlayerBase overrideInteractHooks[];
    private final PlayerBase afterInteractHooks[];
    protected final boolean isInteractModded;
    private static final List beforeIsEntityInsideOpaqueBlockHookTypes = new LinkedList();
    private static final List overrideIsEntityInsideOpaqueBlockHookTypes = new LinkedList();
    private static final List afterIsEntityInsideOpaqueBlockHookTypes = new LinkedList();
    private final PlayerBase beforeIsEntityInsideOpaqueBlockHooks[];
    private final PlayerBase overrideIsEntityInsideOpaqueBlockHooks[];
    private final PlayerBase afterIsEntityInsideOpaqueBlockHooks[];
    protected final boolean isIsEntityInsideOpaqueBlockModded;
    private static final List beforeIsInWaterHookTypes = new LinkedList();
    private static final List overrideIsInWaterHookTypes = new LinkedList();
    private static final List afterIsInWaterHookTypes = new LinkedList();
    private final PlayerBase beforeIsInWaterHooks[];
    private final PlayerBase overrideIsInWaterHooks[];
    private final PlayerBase afterIsInWaterHooks[];
    protected final boolean isIsInWaterModded;
    private static final List beforeIsInsideOfMaterialHookTypes = new LinkedList();
    private static final List overrideIsInsideOfMaterialHookTypes = new LinkedList();
    private static final List afterIsInsideOfMaterialHookTypes = new LinkedList();
    private final PlayerBase beforeIsInsideOfMaterialHooks[];
    private final PlayerBase overrideIsInsideOfMaterialHooks[];
    private final PlayerBase afterIsInsideOfMaterialHooks[];
    protected final boolean isIsInsideOfMaterialModded;
    private static final List beforeIsOnLadderHookTypes = new LinkedList();
    private static final List overrideIsOnLadderHookTypes = new LinkedList();
    private static final List afterIsOnLadderHookTypes = new LinkedList();
    private final PlayerBase beforeIsOnLadderHooks[];
    private final PlayerBase overrideIsOnLadderHooks[];
    private final PlayerBase afterIsOnLadderHooks[];
    protected final boolean isIsOnLadderModded;
    private static final List beforeIsPlayerSleepingHookTypes = new LinkedList();
    private static final List overrideIsPlayerSleepingHookTypes = new LinkedList();
    private static final List afterIsPlayerSleepingHookTypes = new LinkedList();
    private final PlayerBase beforeIsPlayerSleepingHooks[];
    private final PlayerBase overrideIsPlayerSleepingHooks[];
    private final PlayerBase afterIsPlayerSleepingHooks[];
    protected final boolean isIsPlayerSleepingModded;
    private static final List beforeJumpHookTypes = new LinkedList();
    private static final List overrideJumpHookTypes = new LinkedList();
    private static final List afterJumpHookTypes = new LinkedList();
    private final PlayerBase beforeJumpHooks[];
    private final PlayerBase overrideJumpHooks[];
    private final PlayerBase afterJumpHooks[];
    protected final boolean isJumpModded;
    private static final List beforeMoveEntityHookTypes = new LinkedList();
    private static final List overrideMoveEntityHookTypes = new LinkedList();
    private static final List afterMoveEntityHookTypes = new LinkedList();
    private final PlayerBase beforeMoveEntityHooks[];
    private final PlayerBase overrideMoveEntityHooks[];
    private final PlayerBase afterMoveEntityHooks[];
    protected final boolean isMoveEntityModded;
    private static final List beforeMoveEntityWithHeadingHookTypes = new LinkedList();
    private static final List overrideMoveEntityWithHeadingHookTypes = new LinkedList();
    private static final List afterMoveEntityWithHeadingHookTypes = new LinkedList();
    private final PlayerBase beforeMoveEntityWithHeadingHooks[];
    private final PlayerBase overrideMoveEntityWithHeadingHooks[];
    private final PlayerBase afterMoveEntityWithHeadingHooks[];
    protected final boolean isMoveEntityWithHeadingModded;
    private static final List beforeMoveFlyingHookTypes = new LinkedList();
    private static final List overrideMoveFlyingHookTypes = new LinkedList();
    private static final List afterMoveFlyingHookTypes = new LinkedList();
    private final PlayerBase beforeMoveFlyingHooks[];
    private final PlayerBase overrideMoveFlyingHooks[];
    private final PlayerBase afterMoveFlyingHooks[];
    protected final boolean isMoveFlyingModded;
    private static final List beforeOnDeathHookTypes = new LinkedList();
    private static final List overrideOnDeathHookTypes = new LinkedList();
    private static final List afterOnDeathHookTypes = new LinkedList();
    private final PlayerBase beforeOnDeathHooks[];
    private final PlayerBase overrideOnDeathHooks[];
    private final PlayerBase afterOnDeathHooks[];
    protected final boolean isOnDeathModded;
    private static final List beforeOnLivingUpdateHookTypes = new LinkedList();
    private static final List overrideOnLivingUpdateHookTypes = new LinkedList();
    private static final List afterOnLivingUpdateHookTypes = new LinkedList();
    private final PlayerBase beforeOnLivingUpdateHooks[];
    private final PlayerBase overrideOnLivingUpdateHooks[];
    private final PlayerBase afterOnLivingUpdateHooks[];
    protected final boolean isOnLivingUpdateModded;
    private static final List beforeOnKillEntityHookTypes = new LinkedList();
    private static final List overrideOnKillEntityHookTypes = new LinkedList();
    private static final List afterOnKillEntityHookTypes = new LinkedList();
    private final PlayerBase beforeOnKillEntityHooks[];
    private final PlayerBase overrideOnKillEntityHooks[];
    private final PlayerBase afterOnKillEntityHooks[];
    protected final boolean isOnKillEntityModded;
    private static final List beforeOnUpdateHookTypes = new LinkedList();
    private static final List overrideOnUpdateHookTypes = new LinkedList();
    private static final List afterOnUpdateHookTypes = new LinkedList();
    private final PlayerBase beforeOnUpdateHooks[];
    private final PlayerBase overrideOnUpdateHooks[];
    private final PlayerBase afterOnUpdateHooks[];
    protected final boolean isOnUpdateModded;
    private static final List beforeOnUpdateEntityHookTypes = new LinkedList();
    private static final List overrideOnUpdateEntityHookTypes = new LinkedList();
    private static final List afterOnUpdateEntityHookTypes = new LinkedList();
    private final PlayerBase beforeOnUpdateEntityHooks[];
    private final PlayerBase overrideOnUpdateEntityHooks[];
    private final PlayerBase afterOnUpdateEntityHooks[];
    protected final boolean isOnUpdateEntityModded;
    private static final List beforeReadEntityFromNBTHookTypes = new LinkedList();
    private static final List overrideReadEntityFromNBTHookTypes = new LinkedList();
    private static final List afterReadEntityFromNBTHookTypes = new LinkedList();
    private final PlayerBase beforeReadEntityFromNBTHooks[];
    private final PlayerBase overrideReadEntityFromNBTHooks[];
    private final PlayerBase afterReadEntityFromNBTHooks[];
    protected final boolean isReadEntityFromNBTModded;
    private static final List beforeSetDeadHookTypes = new LinkedList();
    private static final List overrideSetDeadHookTypes = new LinkedList();
    private static final List afterSetDeadHookTypes = new LinkedList();
    private final PlayerBase beforeSetDeadHooks[];
    private final PlayerBase overrideSetDeadHooks[];
    private final PlayerBase afterSetDeadHooks[];
    protected final boolean isSetDeadModded;
    private static final List beforeSetPositionHookTypes = new LinkedList();
    private static final List overrideSetPositionHookTypes = new LinkedList();
    private static final List afterSetPositionHookTypes = new LinkedList();
    private final PlayerBase beforeSetPositionHooks[];
    private final PlayerBase overrideSetPositionHooks[];
    private final PlayerBase afterSetPositionHooks[];
    protected final boolean isSetPositionModded;
    private static final List beforeUpdateEntityActionStateHookTypes = new LinkedList();
    private static final List overrideUpdateEntityActionStateHookTypes = new LinkedList();
    private static final List afterUpdateEntityActionStateHookTypes = new LinkedList();
    private final PlayerBase beforeUpdateEntityActionStateHooks[];
    private final PlayerBase overrideUpdateEntityActionStateHooks[];
    private final PlayerBase afterUpdateEntityActionStateHooks[];
    protected final boolean isUpdateEntityActionStateModded;
    private static final List beforeWriteEntityToNBTHookTypes = new LinkedList();
    private static final List overrideWriteEntityToNBTHookTypes = new LinkedList();
    private static final List afterWriteEntityToNBTHookTypes = new LinkedList();
    private final PlayerBase beforeWriteEntityToNBTHooks[];
    private final PlayerBase overrideWriteEntityToNBTHooks[];
    private final PlayerBase afterWriteEntityToNBTHooks[];
    protected final boolean isWriteEntityToNBTModded;
    protected final EntityPlayerMP player;
    private static final List beforeLocalConstructingHookTypes = new LinkedList();
    private static final List afterLocalConstructingHookTypes = new LinkedList();
    private final PlayerBase beforeLocalConstructingHooks[];
    private final PlayerBase afterLocalConstructingHooks[];
    private final Map allBaseObjects = new Hashtable();
    private final Set unmodifiableAllBaseIds;
    private static final Map allBaseConstructors;
    private static final Set unmodifiableAllIds;
    private static final Map allBaseBeforeSuperiors = new Hashtable();
    private static final Map allBaseBeforeInferiors = new Hashtable();
    private static final Map allBaseOverrideSuperiors = new Hashtable();
    private static final Map allBaseOverrideInferiors = new Hashtable();
    private static final Map allBaseAfterSuperiors = new Hashtable();
    private static final Map allBaseAfterInferiors = new Hashtable();
    private static boolean initialized = false;

    private static void log(String s)
    {
        System.out.println(s);
        logger.fine(s);
    }

    public static void register(String s, Class class1)
    {
        register(s, class1, null);
    }

    public static void register(String s, Class class1, PlayerBaseSorting playerbasesorting)
    {
        try
        {
            register(class1, s, playerbasesorting);
        }
        catch (RuntimeException runtimeexception)
        {
            if (s != null)
            {
                log((new StringBuilder()).append("PlayerAPI: failed to register id '").append(s).append("'").toString());
            }
            else
            {
                log("PlayerAPI: failed to register PlayerBase");
            }

            throw runtimeexception;
        }
    }

    private static void register(Class class1, String s, PlayerBaseSorting playerbasesorting)
    {
        if (!isCreated)
        {
            log("PlayerAPI 1.2 Created");
            isCreated = true;
        }

        if (s == null)
        {
            throw new NullPointerException("Argument 'id' can not be null");
        }

        if (class1 == null)
        {
            throw new NullPointerException("Argument 'baseClass' can not be null");
        }

        Constructor constructor = (Constructor)allBaseConstructors.get(s);

        if (constructor != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("The class '").append(class1.getName()).append("' can not be registered with the id '").append(s).append("' because the class '").append(constructor.getDeclaringClass().getName()).append("' has allready been registered with the same id").toString());
        }

        Constructor constructor1;

        try
        {
            constructor1 = class1.getDeclaredConstructor(Classes);
        }
        catch (Exception exception)
        {
            try
            {
                constructor1 = class1.getDeclaredConstructor(Class);
            }
            catch (Exception exception1)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Can not find necessary constructor with one argument of type '").append((net.minecraft.src.PlayerAPI.class).getName()).append("' and eventually a second argument of type 'String' in the class '").append(class1.getName()).append("'").toString(), exception);
            }
        }

        allBaseConstructors.put(s, constructor1);

        if (playerbasesorting != null)
        {
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeLocalConstructingSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeLocalConstructingInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterLocalConstructingSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterLocalConstructingInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeAttackEntityFromSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeAttackEntityFromInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideAttackEntityFromSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideAttackEntityFromInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterAttackEntityFromSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterAttackEntityFromInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeAttackTargetEntityWithCurrentItemSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeAttackTargetEntityWithCurrentItemInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideAttackTargetEntityWithCurrentItemSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideAttackTargetEntityWithCurrentItemInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterAttackTargetEntityWithCurrentItemSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterAttackTargetEntityWithCurrentItemInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeCanHarvestBlockSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeCanHarvestBlockInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideCanHarvestBlockSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideCanHarvestBlockInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterCanHarvestBlockSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterCanHarvestBlockInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeCanPlayerEditSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeCanPlayerEditInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideCanPlayerEditSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideCanPlayerEditInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterCanPlayerEditSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterCanPlayerEditInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeCanTriggerWalkingSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeCanTriggerWalkingInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideCanTriggerWalkingSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideCanTriggerWalkingInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterCanTriggerWalkingSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterCanTriggerWalkingInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeDamageEntitySuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeDamageEntityInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideDamageEntitySuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideDamageEntityInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterDamageEntitySuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterDamageEntityInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeDisplayGUIChestSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeDisplayGUIChestInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideDisplayGUIChestSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideDisplayGUIChestInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterDisplayGUIChestSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterDisplayGUIChestInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeDisplayGUIDispenserSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeDisplayGUIDispenserInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideDisplayGUIDispenserSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideDisplayGUIDispenserInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterDisplayGUIDispenserSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterDisplayGUIDispenserInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeDisplayGUIFurnaceSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeDisplayGUIFurnaceInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideDisplayGUIFurnaceSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideDisplayGUIFurnaceInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterDisplayGUIFurnaceSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterDisplayGUIFurnaceInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeDisplayWorkbenchGUISuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeDisplayWorkbenchGUIInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideDisplayWorkbenchGUISuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideDisplayWorkbenchGUIInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterDisplayWorkbenchGUISuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterDisplayWorkbenchGUIInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeDropOneItemSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeDropOneItemInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideDropOneItemSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideDropOneItemInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterDropOneItemSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterDropOneItemInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeDropPlayerItemSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeDropPlayerItemInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideDropPlayerItemSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideDropPlayerItemInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterDropPlayerItemSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterDropPlayerItemInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeFallSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeFallInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideFallSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideFallInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterFallSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterFallInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeGetCurrentPlayerStrVsBlockSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeGetCurrentPlayerStrVsBlockInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideGetCurrentPlayerStrVsBlockSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideGetCurrentPlayerStrVsBlockInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterGetCurrentPlayerStrVsBlockSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterGetCurrentPlayerStrVsBlockInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeGetDistanceSqSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeGetDistanceSqInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideGetDistanceSqSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideGetDistanceSqInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterGetDistanceSqSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterGetDistanceSqInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeGetBrightnessSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeGetBrightnessInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideGetBrightnessSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideGetBrightnessInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterGetBrightnessSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterGetBrightnessInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeGetEyeHeightSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeGetEyeHeightInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideGetEyeHeightSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideGetEyeHeightInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterGetEyeHeightSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterGetEyeHeightInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeHealSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeHealInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideHealSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideHealInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterHealSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterHealInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeInteractSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeInteractInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideInteractSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideInteractInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterInteractSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterInteractInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeIsEntityInsideOpaqueBlockSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeIsEntityInsideOpaqueBlockInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideIsEntityInsideOpaqueBlockSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideIsEntityInsideOpaqueBlockInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterIsEntityInsideOpaqueBlockSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterIsEntityInsideOpaqueBlockInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeIsInWaterSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeIsInWaterInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideIsInWaterSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideIsInWaterInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterIsInWaterSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterIsInWaterInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeIsInsideOfMaterialSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeIsInsideOfMaterialInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideIsInsideOfMaterialSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideIsInsideOfMaterialInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterIsInsideOfMaterialSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterIsInsideOfMaterialInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeIsOnLadderSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeIsOnLadderInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideIsOnLadderSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideIsOnLadderInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterIsOnLadderSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterIsOnLadderInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeIsPlayerSleepingSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeIsPlayerSleepingInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideIsPlayerSleepingSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideIsPlayerSleepingInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterIsPlayerSleepingSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterIsPlayerSleepingInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeJumpSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeJumpInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideJumpSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideJumpInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterJumpSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterJumpInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeMoveEntitySuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeMoveEntityInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideMoveEntitySuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideMoveEntityInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterMoveEntitySuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterMoveEntityInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeMoveEntityWithHeadingSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeMoveEntityWithHeadingInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideMoveEntityWithHeadingSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideMoveEntityWithHeadingInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterMoveEntityWithHeadingSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterMoveEntityWithHeadingInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeMoveFlyingSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeMoveFlyingInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideMoveFlyingSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideMoveFlyingInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterMoveFlyingSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterMoveFlyingInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeOnDeathSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeOnDeathInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideOnDeathSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideOnDeathInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterOnDeathSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterOnDeathInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeOnLivingUpdateSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeOnLivingUpdateInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideOnLivingUpdateSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideOnLivingUpdateInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterOnLivingUpdateSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterOnLivingUpdateInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeOnKillEntitySuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeOnKillEntityInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideOnKillEntitySuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideOnKillEntityInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterOnKillEntitySuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterOnKillEntityInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeOnUpdateSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeOnUpdateInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideOnUpdateSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideOnUpdateInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterOnUpdateSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterOnUpdateInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeOnUpdateEntitySuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeOnUpdateEntityInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideOnUpdateEntitySuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideOnUpdateEntityInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterOnUpdateEntitySuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterOnUpdateEntityInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeReadEntityFromNBTSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeReadEntityFromNBTInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideReadEntityFromNBTSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideReadEntityFromNBTInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterReadEntityFromNBTSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterReadEntityFromNBTInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeSetDeadSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeSetDeadInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideSetDeadSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideSetDeadInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterSetDeadSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterSetDeadInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeSetPositionSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeSetPositionInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideSetPositionSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideSetPositionInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterSetPositionSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterSetPositionInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeUpdateEntityActionStateSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeUpdateEntityActionStateInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideUpdateEntityActionStateSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideUpdateEntityActionStateInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterUpdateEntityActionStateSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterUpdateEntityActionStateInferiors());
            addSorting(s, allBaseBeforeSuperiors, playerbasesorting.getBeforeWriteEntityToNBTSuperiors());
            addSorting(s, allBaseBeforeInferiors, playerbasesorting.getBeforeWriteEntityToNBTInferiors());
            addSorting(s, allBaseOverrideSuperiors, playerbasesorting.getOverrideWriteEntityToNBTSuperiors());
            addSorting(s, allBaseOverrideInferiors, playerbasesorting.getOverrideWriteEntityToNBTInferiors());
            addSorting(s, allBaseAfterSuperiors, playerbasesorting.getAfterWriteEntityToNBTSuperiors());
            addSorting(s, allBaseAfterInferiors, playerbasesorting.getAfterWriteEntityToNBTInferiors());
        }

        addMethod(s, class1, beforeLocalConstructingHookTypes, "beforeLocalConstructing", new Class[]
                {
                    net.minecraft.server.MinecraftServer.class, net.minecraft.src.World.class, java.lang.String.class, net.minecraft.src.ItemInWorldManager.class
                });
        addMethod(s, class1, afterLocalConstructingHookTypes, "afterLocalConstructing", new Class[]
                {
                    net.minecraft.server.MinecraftServer.class, net.minecraft.src.World.class, java.lang.String.class, net.minecraft.src.ItemInWorldManager.class
                });
        addMethod(s, class1, beforeAttackEntityFromHookTypes, "beforeAttackEntityFrom", new Class[]
                {
                    net.minecraft.src.DamageSource.class, Integer.TYPE
                });
        addMethod(s, class1, overrideAttackEntityFromHookTypes, "attackEntityFrom", new Class[]
                {
                    net.minecraft.src.DamageSource.class, Integer.TYPE
                });
        addMethod(s, class1, afterAttackEntityFromHookTypes, "afterAttackEntityFrom", new Class[]
                {
                    net.minecraft.src.DamageSource.class, Integer.TYPE
                });
        addMethod(s, class1, beforeAttackTargetEntityWithCurrentItemHookTypes, "beforeAttackTargetEntityWithCurrentItem", new Class[]
                {
                    net.minecraft.src.Entity.class
                });
        addMethod(s, class1, overrideAttackTargetEntityWithCurrentItemHookTypes, "attackTargetEntityWithCurrentItem", new Class[]
                {
                    net.minecraft.src.Entity.class
                });
        addMethod(s, class1, afterAttackTargetEntityWithCurrentItemHookTypes, "afterAttackTargetEntityWithCurrentItem", new Class[]
                {
                    net.minecraft.src.Entity.class
                });
        addMethod(s, class1, beforeCanHarvestBlockHookTypes, "beforeCanHarvestBlock", new Class[]
                {
                    net.minecraft.src.Block.class
                });
        addMethod(s, class1, overrideCanHarvestBlockHookTypes, "canHarvestBlock", new Class[]
                {
                    net.minecraft.src.Block.class
                });
        addMethod(s, class1, afterCanHarvestBlockHookTypes, "afterCanHarvestBlock", new Class[]
                {
                    net.minecraft.src.Block.class
                });
        addMethod(s, class1, beforeCanPlayerEditHookTypes, "beforeCanPlayerEdit", new Class[]
                {
                    Integer.TYPE, Integer.TYPE, Integer.TYPE
                });
        addMethod(s, class1, overrideCanPlayerEditHookTypes, "canPlayerEdit", new Class[]
                {
                    Integer.TYPE, Integer.TYPE, Integer.TYPE
                });
        addMethod(s, class1, afterCanPlayerEditHookTypes, "afterCanPlayerEdit", new Class[]
                {
                    Integer.TYPE, Integer.TYPE, Integer.TYPE
                });
        addMethod(s, class1, beforeCanTriggerWalkingHookTypes, "beforeCanTriggerWalking", new Class[0]);
        addMethod(s, class1, overrideCanTriggerWalkingHookTypes, "canTriggerWalking", new Class[0]);
        addMethod(s, class1, afterCanTriggerWalkingHookTypes, "afterCanTriggerWalking", new Class[0]);
        addMethod(s, class1, beforeDamageEntityHookTypes, "beforeDamageEntity", new Class[]
                {
                    net.minecraft.src.DamageSource.class, Integer.TYPE
                });
        addMethod(s, class1, overrideDamageEntityHookTypes, "damageEntity", new Class[]
                {
                    net.minecraft.src.DamageSource.class, Integer.TYPE
                });
        addMethod(s, class1, afterDamageEntityHookTypes, "afterDamageEntity", new Class[]
                {
                    net.minecraft.src.DamageSource.class, Integer.TYPE
                });
        addMethod(s, class1, beforeDisplayGUIChestHookTypes, "beforeDisplayGUIChest", new Class[]
                {
                    net.minecraft.src.IInventory.class
                });
        addMethod(s, class1, overrideDisplayGUIChestHookTypes, "displayGUIChest", new Class[]
                {
                    net.minecraft.src.IInventory.class
                });
        addMethod(s, class1, afterDisplayGUIChestHookTypes, "afterDisplayGUIChest", new Class[]
                {
                    net.minecraft.src.IInventory.class
                });
        addMethod(s, class1, beforeDisplayGUIDispenserHookTypes, "beforeDisplayGUIDispenser", new Class[]
                {
                    net.minecraft.src.TileEntityDispenser.class
                });
        addMethod(s, class1, overrideDisplayGUIDispenserHookTypes, "displayGUIDispenser", new Class[]
                {
                    net.minecraft.src.TileEntityDispenser.class
                });
        addMethod(s, class1, afterDisplayGUIDispenserHookTypes, "afterDisplayGUIDispenser", new Class[]
                {
                    net.minecraft.src.TileEntityDispenser.class
                });
        addMethod(s, class1, beforeDisplayGUIFurnaceHookTypes, "beforeDisplayGUIFurnace", new Class[]
                {
                    net.minecraft.src.TileEntityFurnace.class
                });
        addMethod(s, class1, overrideDisplayGUIFurnaceHookTypes, "displayGUIFurnace", new Class[]
                {
                    net.minecraft.src.TileEntityFurnace.class
                });
        addMethod(s, class1, afterDisplayGUIFurnaceHookTypes, "afterDisplayGUIFurnace", new Class[]
                {
                    net.minecraft.src.TileEntityFurnace.class
                });
        addMethod(s, class1, beforeDisplayWorkbenchGUIHookTypes, "beforeDisplayWorkbenchGUI", new Class[]
                {
                    Integer.TYPE, Integer.TYPE, Integer.TYPE
                });
        addMethod(s, class1, overrideDisplayWorkbenchGUIHookTypes, "displayWorkbenchGUI", new Class[]
                {
                    Integer.TYPE, Integer.TYPE, Integer.TYPE
                });
        addMethod(s, class1, afterDisplayWorkbenchGUIHookTypes, "afterDisplayWorkbenchGUI", new Class[]
                {
                    Integer.TYPE, Integer.TYPE, Integer.TYPE
                });
        addMethod(s, class1, beforeDropOneItemHookTypes, "beforeDropOneItem", new Class[0]);
        addMethod(s, class1, overrideDropOneItemHookTypes, "dropOneItem", new Class[0]);
        addMethod(s, class1, afterDropOneItemHookTypes, "afterDropOneItem", new Class[0]);
        addMethod(s, class1, beforeDropPlayerItemHookTypes, "beforeDropPlayerItem", new Class[]
                {
                    net.minecraft.src.ItemStack.class
                });
        addMethod(s, class1, overrideDropPlayerItemHookTypes, "dropPlayerItem", new Class[]
                {
                    net.minecraft.src.ItemStack.class
                });
        addMethod(s, class1, afterDropPlayerItemHookTypes, "afterDropPlayerItem", new Class[]
                {
                    net.minecraft.src.ItemStack.class
                });
        addMethod(s, class1, beforeFallHookTypes, "beforeFall", new Class[]
                {
                    Float.TYPE
                });
        addMethod(s, class1, overrideFallHookTypes, "fall", new Class[]
                {
                    Float.TYPE
                });
        addMethod(s, class1, afterFallHookTypes, "afterFall", new Class[]
                {
                    Float.TYPE
                });
        addMethod(s, class1, beforeGetCurrentPlayerStrVsBlockHookTypes, "beforeGetCurrentPlayerStrVsBlock", new Class[]
                {
                    net.minecraft.src.Block.class
                });
        addMethod(s, class1, overrideGetCurrentPlayerStrVsBlockHookTypes, "getCurrentPlayerStrVsBlock", new Class[]
                {
                    net.minecraft.src.Block.class
                });
        addMethod(s, class1, afterGetCurrentPlayerStrVsBlockHookTypes, "afterGetCurrentPlayerStrVsBlock", new Class[]
                {
                    net.minecraft.src.Block.class
                });
        addMethod(s, class1, beforeGetDistanceSqHookTypes, "beforeGetDistanceSq", new Class[]
                {
                    Double.TYPE, Double.TYPE, Double.TYPE
                });
        addMethod(s, class1, overrideGetDistanceSqHookTypes, "getDistanceSq", new Class[]
                {
                    Double.TYPE, Double.TYPE, Double.TYPE
                });
        addMethod(s, class1, afterGetDistanceSqHookTypes, "afterGetDistanceSq", new Class[]
                {
                    Double.TYPE, Double.TYPE, Double.TYPE
                });
        addMethod(s, class1, beforeGetBrightnessHookTypes, "beforeGetBrightness", new Class[]
                {
                    Float.TYPE
                });
        addMethod(s, class1, overrideGetBrightnessHookTypes, "getBrightness", new Class[]
                {
                    Float.TYPE
                });
        addMethod(s, class1, afterGetBrightnessHookTypes, "afterGetBrightness", new Class[]
                {
                    Float.TYPE
                });
        addMethod(s, class1, beforeGetEyeHeightHookTypes, "beforeGetEyeHeight", new Class[0]);
        addMethod(s, class1, overrideGetEyeHeightHookTypes, "getEyeHeight", new Class[0]);
        addMethod(s, class1, afterGetEyeHeightHookTypes, "afterGetEyeHeight", new Class[0]);
        addMethod(s, class1, beforeHealHookTypes, "beforeHeal", new Class[]
                {
                    Integer.TYPE
                });
        addMethod(s, class1, overrideHealHookTypes, "heal", new Class[]
                {
                    Integer.TYPE
                });
        addMethod(s, class1, afterHealHookTypes, "afterHeal", new Class[]
                {
                    Integer.TYPE
                });
        addMethod(s, class1, beforeInteractHookTypes, "beforeInteract", new Class[]
                {
                    net.minecraft.src.EntityPlayer.class
                });
        addMethod(s, class1, overrideInteractHookTypes, "interact", new Class[]
                {
                    net.minecraft.src.EntityPlayer.class
                });
        addMethod(s, class1, afterInteractHookTypes, "afterInteract", new Class[]
                {
                    net.minecraft.src.EntityPlayer.class
                });
        addMethod(s, class1, beforeIsEntityInsideOpaqueBlockHookTypes, "beforeIsEntityInsideOpaqueBlock", new Class[0]);
        addMethod(s, class1, overrideIsEntityInsideOpaqueBlockHookTypes, "isEntityInsideOpaqueBlock", new Class[0]);
        addMethod(s, class1, afterIsEntityInsideOpaqueBlockHookTypes, "afterIsEntityInsideOpaqueBlock", new Class[0]);
        addMethod(s, class1, beforeIsInWaterHookTypes, "beforeIsInWater", new Class[0]);
        addMethod(s, class1, overrideIsInWaterHookTypes, "isInWater", new Class[0]);
        addMethod(s, class1, afterIsInWaterHookTypes, "afterIsInWater", new Class[0]);
        addMethod(s, class1, beforeIsInsideOfMaterialHookTypes, "beforeIsInsideOfMaterial", new Class[]
                {
                    net.minecraft.src.Material.class
                });
        addMethod(s, class1, overrideIsInsideOfMaterialHookTypes, "isInsideOfMaterial", new Class[]
                {
                    net.minecraft.src.Material.class
                });
        addMethod(s, class1, afterIsInsideOfMaterialHookTypes, "afterIsInsideOfMaterial", new Class[]
                {
                    net.minecraft.src.Material.class
                });
        addMethod(s, class1, beforeIsOnLadderHookTypes, "beforeIsOnLadder", new Class[0]);
        addMethod(s, class1, overrideIsOnLadderHookTypes, "isOnLadder", new Class[0]);
        addMethod(s, class1, afterIsOnLadderHookTypes, "afterIsOnLadder", new Class[0]);
        addMethod(s, class1, beforeIsPlayerSleepingHookTypes, "beforeIsPlayerSleeping", new Class[0]);
        addMethod(s, class1, overrideIsPlayerSleepingHookTypes, "isPlayerSleeping", new Class[0]);
        addMethod(s, class1, afterIsPlayerSleepingHookTypes, "afterIsPlayerSleeping", new Class[0]);
        addMethod(s, class1, beforeJumpHookTypes, "beforeJump", new Class[0]);
        addMethod(s, class1, overrideJumpHookTypes, "jump", new Class[0]);
        addMethod(s, class1, afterJumpHookTypes, "afterJump", new Class[0]);
        addMethod(s, class1, beforeMoveEntityHookTypes, "beforeMoveEntity", new Class[]
                {
                    Double.TYPE, Double.TYPE, Double.TYPE
                });
        addMethod(s, class1, overrideMoveEntityHookTypes, "moveEntity", new Class[]
                {
                    Double.TYPE, Double.TYPE, Double.TYPE
                });
        addMethod(s, class1, afterMoveEntityHookTypes, "afterMoveEntity", new Class[]
                {
                    Double.TYPE, Double.TYPE, Double.TYPE
                });
        addMethod(s, class1, beforeMoveEntityWithHeadingHookTypes, "beforeMoveEntityWithHeading", new Class[]
                {
                    Float.TYPE, Float.TYPE
                });
        addMethod(s, class1, overrideMoveEntityWithHeadingHookTypes, "moveEntityWithHeading", new Class[]
                {
                    Float.TYPE, Float.TYPE
                });
        addMethod(s, class1, afterMoveEntityWithHeadingHookTypes, "afterMoveEntityWithHeading", new Class[]
                {
                    Float.TYPE, Float.TYPE
                });
        addMethod(s, class1, beforeMoveFlyingHookTypes, "beforeMoveFlying", new Class[]
                {
                    Float.TYPE, Float.TYPE, Float.TYPE
                });
        addMethod(s, class1, overrideMoveFlyingHookTypes, "moveFlying", new Class[]
                {
                    Float.TYPE, Float.TYPE, Float.TYPE
                });
        addMethod(s, class1, afterMoveFlyingHookTypes, "afterMoveFlying", new Class[]
                {
                    Float.TYPE, Float.TYPE, Float.TYPE
                });
        addMethod(s, class1, beforeOnDeathHookTypes, "beforeOnDeath", new Class[]
                {
                    net.minecraft.src.DamageSource.class
                });
        addMethod(s, class1, overrideOnDeathHookTypes, "onDeath", new Class[]
                {
                    net.minecraft.src.DamageSource.class
                });
        addMethod(s, class1, afterOnDeathHookTypes, "afterOnDeath", new Class[]
                {
                    net.minecraft.src.DamageSource.class
                });
        addMethod(s, class1, beforeOnLivingUpdateHookTypes, "beforeOnLivingUpdate", new Class[0]);
        addMethod(s, class1, overrideOnLivingUpdateHookTypes, "onLivingUpdate", new Class[0]);
        addMethod(s, class1, afterOnLivingUpdateHookTypes, "afterOnLivingUpdate", new Class[0]);
        addMethod(s, class1, beforeOnKillEntityHookTypes, "beforeOnKillEntity", new Class[]
                {
                    net.minecraft.src.EntityLiving.class
                });
        addMethod(s, class1, overrideOnKillEntityHookTypes, "onKillEntity", new Class[]
                {
                    net.minecraft.src.EntityLiving.class
                });
        addMethod(s, class1, afterOnKillEntityHookTypes, "afterOnKillEntity", new Class[]
                {
                    net.minecraft.src.EntityLiving.class
                });
        addMethod(s, class1, beforeOnUpdateHookTypes, "beforeOnUpdate", new Class[0]);
        addMethod(s, class1, overrideOnUpdateHookTypes, "onUpdate", new Class[0]);
        addMethod(s, class1, afterOnUpdateHookTypes, "afterOnUpdate", new Class[0]);
        addMethod(s, class1, beforeOnUpdateEntityHookTypes, "beforeOnUpdateEntity", new Class[]
                {
                    Boolean.TYPE
                });
        addMethod(s, class1, overrideOnUpdateEntityHookTypes, "onUpdateEntity", new Class[]
                {
                    Boolean.TYPE
                });
        addMethod(s, class1, afterOnUpdateEntityHookTypes, "afterOnUpdateEntity", new Class[]
                {
                    Boolean.TYPE
                });
        addMethod(s, class1, beforeReadEntityFromNBTHookTypes, "beforeReadEntityFromNBT", new Class[]
                {
                    net.minecraft.src.NBTTagCompound.class
                });
        addMethod(s, class1, overrideReadEntityFromNBTHookTypes, "readEntityFromNBT", new Class[]
                {
                    net.minecraft.src.NBTTagCompound.class
                });
        addMethod(s, class1, afterReadEntityFromNBTHookTypes, "afterReadEntityFromNBT", new Class[]
                {
                    net.minecraft.src.NBTTagCompound.class
                });
        addMethod(s, class1, beforeSetDeadHookTypes, "beforeSetDead", new Class[0]);
        addMethod(s, class1, overrideSetDeadHookTypes, "setDead", new Class[0]);
        addMethod(s, class1, afterSetDeadHookTypes, "afterSetDead", new Class[0]);
        addMethod(s, class1, beforeSetPositionHookTypes, "beforeSetPosition", new Class[]
                {
                    Double.TYPE, Double.TYPE, Double.TYPE
                });
        addMethod(s, class1, overrideSetPositionHookTypes, "setPosition", new Class[]
                {
                    Double.TYPE, Double.TYPE, Double.TYPE
                });
        addMethod(s, class1, afterSetPositionHookTypes, "afterSetPosition", new Class[]
                {
                    Double.TYPE, Double.TYPE, Double.TYPE
                });
        addMethod(s, class1, beforeUpdateEntityActionStateHookTypes, "beforeUpdateEntityActionState", new Class[0]);
        addMethod(s, class1, overrideUpdateEntityActionStateHookTypes, "updateEntityActionState", new Class[0]);
        addMethod(s, class1, afterUpdateEntityActionStateHookTypes, "afterUpdateEntityActionState", new Class[0]);
        addMethod(s, class1, beforeWriteEntityToNBTHookTypes, "beforeWriteEntityToNBT", new Class[]
                {
                    net.minecraft.src.NBTTagCompound.class
                });
        addMethod(s, class1, overrideWriteEntityToNBTHookTypes, "writeEntityToNBT", new Class[]
                {
                    net.minecraft.src.NBTTagCompound.class
                });
        addMethod(s, class1, afterWriteEntityToNBTHookTypes, "afterWriteEntityToNBT", new Class[]
                {
                    net.minecraft.src.NBTTagCompound.class
                });
        System.out.println((new StringBuilder()).append("PlayerAPI: registered ").append(s).toString());
        logger.fine((new StringBuilder()).append("PlayerAPI: registered class '").append(class1.getName()).append("' with id '").append(s).append("'").toString());
        initialized = false;
    }

    public static boolean unregister(String s)
    {
        if (s != null && allBaseConstructors.remove(s) != null)
        {
            allBaseBeforeSuperiors.remove(s);
            allBaseBeforeInferiors.remove(s);
            allBaseOverrideSuperiors.remove(s);
            allBaseOverrideInferiors.remove(s);
            allBaseAfterSuperiors.remove(s);
            allBaseAfterInferiors.remove(s);
            beforeLocalConstructingHookTypes.remove(s);
            afterLocalConstructingHookTypes.remove(s);
            beforeAttackEntityFromHookTypes.remove(s);
            overrideAttackEntityFromHookTypes.remove(s);
            afterAttackEntityFromHookTypes.remove(s);
            beforeAttackTargetEntityWithCurrentItemHookTypes.remove(s);
            overrideAttackTargetEntityWithCurrentItemHookTypes.remove(s);
            afterAttackTargetEntityWithCurrentItemHookTypes.remove(s);
            beforeCanHarvestBlockHookTypes.remove(s);
            overrideCanHarvestBlockHookTypes.remove(s);
            afterCanHarvestBlockHookTypes.remove(s);
            beforeCanPlayerEditHookTypes.remove(s);
            overrideCanPlayerEditHookTypes.remove(s);
            afterCanPlayerEditHookTypes.remove(s);
            beforeCanTriggerWalkingHookTypes.remove(s);
            overrideCanTriggerWalkingHookTypes.remove(s);
            afterCanTriggerWalkingHookTypes.remove(s);
            beforeDamageEntityHookTypes.remove(s);
            overrideDamageEntityHookTypes.remove(s);
            afterDamageEntityHookTypes.remove(s);
            beforeDisplayGUIChestHookTypes.remove(s);
            overrideDisplayGUIChestHookTypes.remove(s);
            afterDisplayGUIChestHookTypes.remove(s);
            beforeDisplayGUIDispenserHookTypes.remove(s);
            overrideDisplayGUIDispenserHookTypes.remove(s);
            afterDisplayGUIDispenserHookTypes.remove(s);
            beforeDisplayGUIFurnaceHookTypes.remove(s);
            overrideDisplayGUIFurnaceHookTypes.remove(s);
            afterDisplayGUIFurnaceHookTypes.remove(s);
            beforeDisplayWorkbenchGUIHookTypes.remove(s);
            overrideDisplayWorkbenchGUIHookTypes.remove(s);
            afterDisplayWorkbenchGUIHookTypes.remove(s);
            beforeDropOneItemHookTypes.remove(s);
            overrideDropOneItemHookTypes.remove(s);
            afterDropOneItemHookTypes.remove(s);
            beforeDropPlayerItemHookTypes.remove(s);
            overrideDropPlayerItemHookTypes.remove(s);
            afterDropPlayerItemHookTypes.remove(s);
            beforeFallHookTypes.remove(s);
            overrideFallHookTypes.remove(s);
            afterFallHookTypes.remove(s);
            beforeGetCurrentPlayerStrVsBlockHookTypes.remove(s);
            overrideGetCurrentPlayerStrVsBlockHookTypes.remove(s);
            afterGetCurrentPlayerStrVsBlockHookTypes.remove(s);
            beforeGetDistanceSqHookTypes.remove(s);
            overrideGetDistanceSqHookTypes.remove(s);
            afterGetDistanceSqHookTypes.remove(s);
            beforeGetBrightnessHookTypes.remove(s);
            overrideGetBrightnessHookTypes.remove(s);
            afterGetBrightnessHookTypes.remove(s);
            beforeGetEyeHeightHookTypes.remove(s);
            overrideGetEyeHeightHookTypes.remove(s);
            afterGetEyeHeightHookTypes.remove(s);
            beforeHealHookTypes.remove(s);
            overrideHealHookTypes.remove(s);
            afterHealHookTypes.remove(s);
            beforeInteractHookTypes.remove(s);
            overrideInteractHookTypes.remove(s);
            afterInteractHookTypes.remove(s);
            beforeIsEntityInsideOpaqueBlockHookTypes.remove(s);
            overrideIsEntityInsideOpaqueBlockHookTypes.remove(s);
            afterIsEntityInsideOpaqueBlockHookTypes.remove(s);
            beforeIsInWaterHookTypes.remove(s);
            overrideIsInWaterHookTypes.remove(s);
            afterIsInWaterHookTypes.remove(s);
            beforeIsInsideOfMaterialHookTypes.remove(s);
            overrideIsInsideOfMaterialHookTypes.remove(s);
            afterIsInsideOfMaterialHookTypes.remove(s);
            beforeIsOnLadderHookTypes.remove(s);
            overrideIsOnLadderHookTypes.remove(s);
            afterIsOnLadderHookTypes.remove(s);
            beforeIsPlayerSleepingHookTypes.remove(s);
            overrideIsPlayerSleepingHookTypes.remove(s);
            afterIsPlayerSleepingHookTypes.remove(s);
            beforeJumpHookTypes.remove(s);
            overrideJumpHookTypes.remove(s);
            afterJumpHookTypes.remove(s);
            beforeMoveEntityHookTypes.remove(s);
            overrideMoveEntityHookTypes.remove(s);
            afterMoveEntityHookTypes.remove(s);
            beforeMoveEntityWithHeadingHookTypes.remove(s);
            overrideMoveEntityWithHeadingHookTypes.remove(s);
            afterMoveEntityWithHeadingHookTypes.remove(s);
            beforeMoveFlyingHookTypes.remove(s);
            overrideMoveFlyingHookTypes.remove(s);
            afterMoveFlyingHookTypes.remove(s);
            beforeOnDeathHookTypes.remove(s);
            overrideOnDeathHookTypes.remove(s);
            afterOnDeathHookTypes.remove(s);
            beforeOnLivingUpdateHookTypes.remove(s);
            overrideOnLivingUpdateHookTypes.remove(s);
            afterOnLivingUpdateHookTypes.remove(s);
            beforeOnKillEntityHookTypes.remove(s);
            overrideOnKillEntityHookTypes.remove(s);
            afterOnKillEntityHookTypes.remove(s);
            beforeOnUpdateHookTypes.remove(s);
            overrideOnUpdateHookTypes.remove(s);
            afterOnUpdateHookTypes.remove(s);
            beforeOnUpdateEntityHookTypes.remove(s);
            overrideOnUpdateEntityHookTypes.remove(s);
            afterOnUpdateEntityHookTypes.remove(s);
            beforeReadEntityFromNBTHookTypes.remove(s);
            overrideReadEntityFromNBTHookTypes.remove(s);
            afterReadEntityFromNBTHookTypes.remove(s);
            beforeSetDeadHookTypes.remove(s);
            overrideSetDeadHookTypes.remove(s);
            afterSetDeadHookTypes.remove(s);
            beforeSetPositionHookTypes.remove(s);
            overrideSetPositionHookTypes.remove(s);
            afterSetPositionHookTypes.remove(s);
            beforeUpdateEntityActionStateHookTypes.remove(s);
            overrideUpdateEntityActionStateHookTypes.remove(s);
            afterUpdateEntityActionStateHookTypes.remove(s);
            beforeWriteEntityToNBTHookTypes.remove(s);
            overrideWriteEntityToNBTHookTypes.remove(s);
            afterWriteEntityToNBTHookTypes.remove(s);
            log((new StringBuilder()).append("PlayerAPI: unregistered id '").append(s).append("'").toString());
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Set getRegisteredIds()
    {
        return unmodifiableAllIds;
    }

    private static void addSorting(String s, Map map, String as[])
    {
        if (as != null && as.length > 0)
        {
            map.put(s, as);
        }
    }

    private static boolean addMethod(String s, Class class1, List list, String s1, Class aclass[])
    {
        try
        {
            Method method = class1.getMethod(s1, aclass);
            boolean flag = method.getDeclaringClass() != (net.minecraft.src.PlayerBase.class);

            if (flag)
            {
                list.add(s);
            }

            return flag;
        }
        catch (Exception exception)
        {
            throw new RuntimeException((new StringBuilder()).append("Can not reflect method '").append(s1).append("' of class '").append(class1.getName()).append("'").toString(), exception);
        }
    }

    public static PlayerAPI create(EntityPlayerMP entityplayermp)
    {
        if (allBaseConstructors.size() > 0)
        {
            if (!initialized)
            {
                initialize();
            }

            return new PlayerAPI(entityplayermp);
        }
        else
        {
            return null;
        }
    }

    private static void initialize()
    {
        sortBases(beforeLocalConstructingHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeLocalConstructing");
        sortBases(afterLocalConstructingHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterLocalConstructing");
        sortBases(beforeAttackEntityFromHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeAttackEntityFrom");
        sortBases(overrideAttackEntityFromHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideAttackEntityFrom");
        sortBases(afterAttackEntityFromHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterAttackEntityFrom");
        sortBases(beforeAttackTargetEntityWithCurrentItemHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeAttackTargetEntityWithCurrentItem");
        sortBases(overrideAttackTargetEntityWithCurrentItemHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideAttackTargetEntityWithCurrentItem");
        sortBases(afterAttackTargetEntityWithCurrentItemHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterAttackTargetEntityWithCurrentItem");
        sortBases(beforeCanHarvestBlockHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeCanHarvestBlock");
        sortBases(overrideCanHarvestBlockHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideCanHarvestBlock");
        sortBases(afterCanHarvestBlockHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterCanHarvestBlock");
        sortBases(beforeCanPlayerEditHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeCanPlayerEdit");
        sortBases(overrideCanPlayerEditHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideCanPlayerEdit");
        sortBases(afterCanPlayerEditHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterCanPlayerEdit");
        sortBases(beforeCanTriggerWalkingHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeCanTriggerWalking");
        sortBases(overrideCanTriggerWalkingHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideCanTriggerWalking");
        sortBases(afterCanTriggerWalkingHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterCanTriggerWalking");
        sortBases(beforeDamageEntityHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeDamageEntity");
        sortBases(overrideDamageEntityHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideDamageEntity");
        sortBases(afterDamageEntityHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterDamageEntity");
        sortBases(beforeDisplayGUIChestHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeDisplayGUIChest");
        sortBases(overrideDisplayGUIChestHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideDisplayGUIChest");
        sortBases(afterDisplayGUIChestHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterDisplayGUIChest");
        sortBases(beforeDisplayGUIDispenserHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeDisplayGUIDispenser");
        sortBases(overrideDisplayGUIDispenserHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideDisplayGUIDispenser");
        sortBases(afterDisplayGUIDispenserHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterDisplayGUIDispenser");
        sortBases(beforeDisplayGUIFurnaceHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeDisplayGUIFurnace");
        sortBases(overrideDisplayGUIFurnaceHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideDisplayGUIFurnace");
        sortBases(afterDisplayGUIFurnaceHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterDisplayGUIFurnace");
        sortBases(beforeDisplayWorkbenchGUIHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeDisplayWorkbenchGUI");
        sortBases(overrideDisplayWorkbenchGUIHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideDisplayWorkbenchGUI");
        sortBases(afterDisplayWorkbenchGUIHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterDisplayWorkbenchGUI");
        sortBases(beforeDropOneItemHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeDropOneItem");
        sortBases(overrideDropOneItemHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideDropOneItem");
        sortBases(afterDropOneItemHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterDropOneItem");
        sortBases(beforeDropPlayerItemHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeDropPlayerItem");
        sortBases(overrideDropPlayerItemHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideDropPlayerItem");
        sortBases(afterDropPlayerItemHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterDropPlayerItem");
        sortBases(beforeFallHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeFall");
        sortBases(overrideFallHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideFall");
        sortBases(afterFallHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterFall");
        sortBases(beforeGetCurrentPlayerStrVsBlockHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeGetCurrentPlayerStrVsBlock");
        sortBases(overrideGetCurrentPlayerStrVsBlockHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideGetCurrentPlayerStrVsBlock");
        sortBases(afterGetCurrentPlayerStrVsBlockHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterGetCurrentPlayerStrVsBlock");
        sortBases(beforeGetDistanceSqHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeGetDistanceSq");
        sortBases(overrideGetDistanceSqHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideGetDistanceSq");
        sortBases(afterGetDistanceSqHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterGetDistanceSq");
        sortBases(beforeGetBrightnessHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeGetBrightness");
        sortBases(overrideGetBrightnessHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideGetBrightness");
        sortBases(afterGetBrightnessHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterGetBrightness");
        sortBases(beforeGetEyeHeightHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeGetEyeHeight");
        sortBases(overrideGetEyeHeightHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideGetEyeHeight");
        sortBases(afterGetEyeHeightHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterGetEyeHeight");
        sortBases(beforeHealHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeHeal");
        sortBases(overrideHealHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideHeal");
        sortBases(afterHealHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterHeal");
        sortBases(beforeInteractHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeInteract");
        sortBases(overrideInteractHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideInteract");
        sortBases(afterInteractHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterInteract");
        sortBases(beforeIsEntityInsideOpaqueBlockHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeIsEntityInsideOpaqueBlock");
        sortBases(overrideIsEntityInsideOpaqueBlockHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideIsEntityInsideOpaqueBlock");
        sortBases(afterIsEntityInsideOpaqueBlockHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterIsEntityInsideOpaqueBlock");
        sortBases(beforeIsInWaterHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeIsInWater");
        sortBases(overrideIsInWaterHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideIsInWater");
        sortBases(afterIsInWaterHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterIsInWater");
        sortBases(beforeIsInsideOfMaterialHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeIsInsideOfMaterial");
        sortBases(overrideIsInsideOfMaterialHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideIsInsideOfMaterial");
        sortBases(afterIsInsideOfMaterialHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterIsInsideOfMaterial");
        sortBases(beforeIsOnLadderHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeIsOnLadder");
        sortBases(overrideIsOnLadderHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideIsOnLadder");
        sortBases(afterIsOnLadderHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterIsOnLadder");
        sortBases(beforeIsPlayerSleepingHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeIsPlayerSleeping");
        sortBases(overrideIsPlayerSleepingHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideIsPlayerSleeping");
        sortBases(afterIsPlayerSleepingHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterIsPlayerSleeping");
        sortBases(beforeJumpHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeJump");
        sortBases(overrideJumpHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideJump");
        sortBases(afterJumpHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterJump");
        sortBases(beforeMoveEntityHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeMoveEntity");
        sortBases(overrideMoveEntityHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideMoveEntity");
        sortBases(afterMoveEntityHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterMoveEntity");
        sortBases(beforeMoveEntityWithHeadingHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeMoveEntityWithHeading");
        sortBases(overrideMoveEntityWithHeadingHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideMoveEntityWithHeading");
        sortBases(afterMoveEntityWithHeadingHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterMoveEntityWithHeading");
        sortBases(beforeMoveFlyingHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeMoveFlying");
        sortBases(overrideMoveFlyingHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideMoveFlying");
        sortBases(afterMoveFlyingHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterMoveFlying");
        sortBases(beforeOnDeathHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeOnDeath");
        sortBases(overrideOnDeathHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideOnDeath");
        sortBases(afterOnDeathHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterOnDeath");
        sortBases(beforeOnLivingUpdateHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeOnLivingUpdate");
        sortBases(overrideOnLivingUpdateHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideOnLivingUpdate");
        sortBases(afterOnLivingUpdateHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterOnLivingUpdate");
        sortBases(beforeOnKillEntityHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeOnKillEntity");
        sortBases(overrideOnKillEntityHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideOnKillEntity");
        sortBases(afterOnKillEntityHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterOnKillEntity");
        sortBases(beforeOnUpdateHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeOnUpdate");
        sortBases(overrideOnUpdateHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideOnUpdate");
        sortBases(afterOnUpdateHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterOnUpdate");
        sortBases(beforeOnUpdateEntityHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeOnUpdateEntity");
        sortBases(overrideOnUpdateEntityHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideOnUpdateEntity");
        sortBases(afterOnUpdateEntityHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterOnUpdateEntity");
        sortBases(beforeReadEntityFromNBTHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeReadEntityFromNBT");
        sortBases(overrideReadEntityFromNBTHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideReadEntityFromNBT");
        sortBases(afterReadEntityFromNBTHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterReadEntityFromNBT");
        sortBases(beforeSetDeadHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeSetDead");
        sortBases(overrideSetDeadHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideSetDead");
        sortBases(afterSetDeadHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterSetDead");
        sortBases(beforeSetPositionHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeSetPosition");
        sortBases(overrideSetPositionHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideSetPosition");
        sortBases(afterSetPositionHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterSetPosition");
        sortBases(beforeUpdateEntityActionStateHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeUpdateEntityActionState");
        sortBases(overrideUpdateEntityActionStateHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideUpdateEntityActionState");
        sortBases(afterUpdateEntityActionStateHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterUpdateEntityActionState");
        sortBases(beforeWriteEntityToNBTHookTypes, allBaseBeforeSuperiors, allBaseBeforeInferiors, "beforeWriteEntityToNBT");
        sortBases(overrideWriteEntityToNBTHookTypes, allBaseOverrideSuperiors, allBaseOverrideInferiors, "overrideWriteEntityToNBT");
        sortBases(afterWriteEntityToNBTHookTypes, allBaseAfterSuperiors, allBaseAfterInferiors, "afterWriteEntityToNBT");
        initialized = true;
    }

    public static void beforeLocalConstructing(EntityPlayerMP entityplayermp, MinecraftServer minecraftserver, World world, String s, ItemInWorldManager iteminworldmanager)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.beforeLocalConstructing(minecraftserver, world, s, iteminworldmanager);
        }
    }

    public static void afterLocalConstructing(EntityPlayerMP entityplayermp, MinecraftServer minecraftserver, World world, String s, ItemInWorldManager iteminworldmanager)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.afterLocalConstructing(minecraftserver, world, s, iteminworldmanager);
        }
    }

    private static void sortBases(List list, Map map, Map map1, String s)
    {
        (new PlayerBaseSorter(list, map, map1, s)).Sort();
    }

    private PlayerAPI(EntityPlayerMP entityplayermp)
    {
        unmodifiableAllBaseIds = Collections.unmodifiableSet(allBaseObjects.keySet());
        player = entityplayermp;
        Object aobj[] =
        {
            this
        };
        Object aobj1[] =
        {
            this, null
        };
        java.util.Map.Entry entry;
        PlayerBase playerbase;

        for (Iterator iterator = allBaseConstructors.entrySet().iterator(); iterator.hasNext(); allBaseObjects.put(entry.getKey(), playerbase))
        {
            entry = (java.util.Map.Entry)iterator.next();
            Constructor constructor = (Constructor)entry.getValue();
            aobj1[1] = entry.getKey();

            try
            {
                if (constructor.getParameterTypes().length == 1)
                {
                    playerbase = (PlayerBase)constructor.newInstance(aobj);
                }
                else
                {
                    playerbase = (PlayerBase)constructor.newInstance(aobj1);
                }
            }
            catch (Exception exception)
            {
                throw new RuntimeException((new StringBuilder()).append("Exception while creating a PlayerBase of type '").append(constructor.getDeclaringClass()).append("'").toString(), exception);
            }
        }

        beforeLocalConstructingHooks = create(beforeLocalConstructingHookTypes);
        afterLocalConstructingHooks = create(afterLocalConstructingHookTypes);
        beforeAttackEntityFromHooks = create(beforeAttackEntityFromHookTypes);
        overrideAttackEntityFromHooks = create(overrideAttackEntityFromHookTypes);
        afterAttackEntityFromHooks = create(afterAttackEntityFromHookTypes);
        isAttackEntityFromModded = beforeAttackEntityFromHooks != null || overrideAttackEntityFromHooks != null || afterAttackEntityFromHooks != null;
        beforeAttackTargetEntityWithCurrentItemHooks = create(beforeAttackTargetEntityWithCurrentItemHookTypes);
        overrideAttackTargetEntityWithCurrentItemHooks = create(overrideAttackTargetEntityWithCurrentItemHookTypes);
        afterAttackTargetEntityWithCurrentItemHooks = create(afterAttackTargetEntityWithCurrentItemHookTypes);
        isAttackTargetEntityWithCurrentItemModded = beforeAttackTargetEntityWithCurrentItemHooks != null || overrideAttackTargetEntityWithCurrentItemHooks != null || afterAttackTargetEntityWithCurrentItemHooks != null;
        beforeCanHarvestBlockHooks = create(beforeCanHarvestBlockHookTypes);
        overrideCanHarvestBlockHooks = create(overrideCanHarvestBlockHookTypes);
        afterCanHarvestBlockHooks = create(afterCanHarvestBlockHookTypes);
        isCanHarvestBlockModded = beforeCanHarvestBlockHooks != null || overrideCanHarvestBlockHooks != null || afterCanHarvestBlockHooks != null;
        beforeCanPlayerEditHooks = create(beforeCanPlayerEditHookTypes);
        overrideCanPlayerEditHooks = create(overrideCanPlayerEditHookTypes);
        afterCanPlayerEditHooks = create(afterCanPlayerEditHookTypes);
        isCanPlayerEditModded = beforeCanPlayerEditHooks != null || overrideCanPlayerEditHooks != null || afterCanPlayerEditHooks != null;
        beforeCanTriggerWalkingHooks = create(beforeCanTriggerWalkingHookTypes);
        overrideCanTriggerWalkingHooks = create(overrideCanTriggerWalkingHookTypes);
        afterCanTriggerWalkingHooks = create(afterCanTriggerWalkingHookTypes);
        isCanTriggerWalkingModded = beforeCanTriggerWalkingHooks != null || overrideCanTriggerWalkingHooks != null || afterCanTriggerWalkingHooks != null;
        beforeDamageEntityHooks = create(beforeDamageEntityHookTypes);
        overrideDamageEntityHooks = create(overrideDamageEntityHookTypes);
        afterDamageEntityHooks = create(afterDamageEntityHookTypes);
        isDamageEntityModded = beforeDamageEntityHooks != null || overrideDamageEntityHooks != null || afterDamageEntityHooks != null;
        beforeDisplayGUIChestHooks = create(beforeDisplayGUIChestHookTypes);
        overrideDisplayGUIChestHooks = create(overrideDisplayGUIChestHookTypes);
        afterDisplayGUIChestHooks = create(afterDisplayGUIChestHookTypes);
        isDisplayGUIChestModded = beforeDisplayGUIChestHooks != null || overrideDisplayGUIChestHooks != null || afterDisplayGUIChestHooks != null;
        beforeDisplayGUIDispenserHooks = create(beforeDisplayGUIDispenserHookTypes);
        overrideDisplayGUIDispenserHooks = create(overrideDisplayGUIDispenserHookTypes);
        afterDisplayGUIDispenserHooks = create(afterDisplayGUIDispenserHookTypes);
        isDisplayGUIDispenserModded = beforeDisplayGUIDispenserHooks != null || overrideDisplayGUIDispenserHooks != null || afterDisplayGUIDispenserHooks != null;
        beforeDisplayGUIFurnaceHooks = create(beforeDisplayGUIFurnaceHookTypes);
        overrideDisplayGUIFurnaceHooks = create(overrideDisplayGUIFurnaceHookTypes);
        afterDisplayGUIFurnaceHooks = create(afterDisplayGUIFurnaceHookTypes);
        isDisplayGUIFurnaceModded = beforeDisplayGUIFurnaceHooks != null || overrideDisplayGUIFurnaceHooks != null || afterDisplayGUIFurnaceHooks != null;
        beforeDisplayWorkbenchGUIHooks = create(beforeDisplayWorkbenchGUIHookTypes);
        overrideDisplayWorkbenchGUIHooks = create(overrideDisplayWorkbenchGUIHookTypes);
        afterDisplayWorkbenchGUIHooks = create(afterDisplayWorkbenchGUIHookTypes);
        isDisplayWorkbenchGUIModded = beforeDisplayWorkbenchGUIHooks != null || overrideDisplayWorkbenchGUIHooks != null || afterDisplayWorkbenchGUIHooks != null;
        beforeDropOneItemHooks = create(beforeDropOneItemHookTypes);
        overrideDropOneItemHooks = create(overrideDropOneItemHookTypes);
        afterDropOneItemHooks = create(afterDropOneItemHookTypes);
        isDropOneItemModded = beforeDropOneItemHooks != null || overrideDropOneItemHooks != null || afterDropOneItemHooks != null;
        beforeDropPlayerItemHooks = create(beforeDropPlayerItemHookTypes);
        overrideDropPlayerItemHooks = create(overrideDropPlayerItemHookTypes);
        afterDropPlayerItemHooks = create(afterDropPlayerItemHookTypes);
        isDropPlayerItemModded = beforeDropPlayerItemHooks != null || overrideDropPlayerItemHooks != null || afterDropPlayerItemHooks != null;
        beforeFallHooks = create(beforeFallHookTypes);
        overrideFallHooks = create(overrideFallHookTypes);
        afterFallHooks = create(afterFallHookTypes);
        isFallModded = beforeFallHooks != null || overrideFallHooks != null || afterFallHooks != null;
        beforeGetCurrentPlayerStrVsBlockHooks = create(beforeGetCurrentPlayerStrVsBlockHookTypes);
        overrideGetCurrentPlayerStrVsBlockHooks = create(overrideGetCurrentPlayerStrVsBlockHookTypes);
        afterGetCurrentPlayerStrVsBlockHooks = create(afterGetCurrentPlayerStrVsBlockHookTypes);
        isGetCurrentPlayerStrVsBlockModded = beforeGetCurrentPlayerStrVsBlockHooks != null || overrideGetCurrentPlayerStrVsBlockHooks != null || afterGetCurrentPlayerStrVsBlockHooks != null;
        beforeGetDistanceSqHooks = create(beforeGetDistanceSqHookTypes);
        overrideGetDistanceSqHooks = create(overrideGetDistanceSqHookTypes);
        afterGetDistanceSqHooks = create(afterGetDistanceSqHookTypes);
        isGetDistanceSqModded = beforeGetDistanceSqHooks != null || overrideGetDistanceSqHooks != null || afterGetDistanceSqHooks != null;
        beforeGetBrightnessHooks = create(beforeGetBrightnessHookTypes);
        overrideGetBrightnessHooks = create(overrideGetBrightnessHookTypes);
        afterGetBrightnessHooks = create(afterGetBrightnessHookTypes);
        isGetBrightnessModded = beforeGetBrightnessHooks != null || overrideGetBrightnessHooks != null || afterGetBrightnessHooks != null;
        beforeGetEyeHeightHooks = create(beforeGetEyeHeightHookTypes);
        overrideGetEyeHeightHooks = create(overrideGetEyeHeightHookTypes);
        afterGetEyeHeightHooks = create(afterGetEyeHeightHookTypes);
        isGetEyeHeightModded = beforeGetEyeHeightHooks != null || overrideGetEyeHeightHooks != null || afterGetEyeHeightHooks != null;
        beforeHealHooks = create(beforeHealHookTypes);
        overrideHealHooks = create(overrideHealHookTypes);
        afterHealHooks = create(afterHealHookTypes);
        isHealModded = beforeHealHooks != null || overrideHealHooks != null || afterHealHooks != null;
        beforeInteractHooks = create(beforeInteractHookTypes);
        overrideInteractHooks = create(overrideInteractHookTypes);
        afterInteractHooks = create(afterInteractHookTypes);
        isInteractModded = beforeInteractHooks != null || overrideInteractHooks != null || afterInteractHooks != null;
        beforeIsEntityInsideOpaqueBlockHooks = create(beforeIsEntityInsideOpaqueBlockHookTypes);
        overrideIsEntityInsideOpaqueBlockHooks = create(overrideIsEntityInsideOpaqueBlockHookTypes);
        afterIsEntityInsideOpaqueBlockHooks = create(afterIsEntityInsideOpaqueBlockHookTypes);
        isIsEntityInsideOpaqueBlockModded = beforeIsEntityInsideOpaqueBlockHooks != null || overrideIsEntityInsideOpaqueBlockHooks != null || afterIsEntityInsideOpaqueBlockHooks != null;
        beforeIsInWaterHooks = create(beforeIsInWaterHookTypes);
        overrideIsInWaterHooks = create(overrideIsInWaterHookTypes);
        afterIsInWaterHooks = create(afterIsInWaterHookTypes);
        isIsInWaterModded = beforeIsInWaterHooks != null || overrideIsInWaterHooks != null || afterIsInWaterHooks != null;
        beforeIsInsideOfMaterialHooks = create(beforeIsInsideOfMaterialHookTypes);
        overrideIsInsideOfMaterialHooks = create(overrideIsInsideOfMaterialHookTypes);
        afterIsInsideOfMaterialHooks = create(afterIsInsideOfMaterialHookTypes);
        isIsInsideOfMaterialModded = beforeIsInsideOfMaterialHooks != null || overrideIsInsideOfMaterialHooks != null || afterIsInsideOfMaterialHooks != null;
        beforeIsOnLadderHooks = create(beforeIsOnLadderHookTypes);
        overrideIsOnLadderHooks = create(overrideIsOnLadderHookTypes);
        afterIsOnLadderHooks = create(afterIsOnLadderHookTypes);
        isIsOnLadderModded = beforeIsOnLadderHooks != null || overrideIsOnLadderHooks != null || afterIsOnLadderHooks != null;
        beforeIsPlayerSleepingHooks = create(beforeIsPlayerSleepingHookTypes);
        overrideIsPlayerSleepingHooks = create(overrideIsPlayerSleepingHookTypes);
        afterIsPlayerSleepingHooks = create(afterIsPlayerSleepingHookTypes);
        isIsPlayerSleepingModded = beforeIsPlayerSleepingHooks != null || overrideIsPlayerSleepingHooks != null || afterIsPlayerSleepingHooks != null;
        beforeJumpHooks = create(beforeJumpHookTypes);
        overrideJumpHooks = create(overrideJumpHookTypes);
        afterJumpHooks = create(afterJumpHookTypes);
        isJumpModded = beforeJumpHooks != null || overrideJumpHooks != null || afterJumpHooks != null;
        beforeMoveEntityHooks = create(beforeMoveEntityHookTypes);
        overrideMoveEntityHooks = create(overrideMoveEntityHookTypes);
        afterMoveEntityHooks = create(afterMoveEntityHookTypes);
        isMoveEntityModded = beforeMoveEntityHooks != null || overrideMoveEntityHooks != null || afterMoveEntityHooks != null;
        beforeMoveEntityWithHeadingHooks = create(beforeMoveEntityWithHeadingHookTypes);
        overrideMoveEntityWithHeadingHooks = create(overrideMoveEntityWithHeadingHookTypes);
        afterMoveEntityWithHeadingHooks = create(afterMoveEntityWithHeadingHookTypes);
        isMoveEntityWithHeadingModded = beforeMoveEntityWithHeadingHooks != null || overrideMoveEntityWithHeadingHooks != null || afterMoveEntityWithHeadingHooks != null;
        beforeMoveFlyingHooks = create(beforeMoveFlyingHookTypes);
        overrideMoveFlyingHooks = create(overrideMoveFlyingHookTypes);
        afterMoveFlyingHooks = create(afterMoveFlyingHookTypes);
        isMoveFlyingModded = beforeMoveFlyingHooks != null || overrideMoveFlyingHooks != null || afterMoveFlyingHooks != null;
        beforeOnDeathHooks = create(beforeOnDeathHookTypes);
        overrideOnDeathHooks = create(overrideOnDeathHookTypes);
        afterOnDeathHooks = create(afterOnDeathHookTypes);
        isOnDeathModded = beforeOnDeathHooks != null || overrideOnDeathHooks != null || afterOnDeathHooks != null;
        beforeOnLivingUpdateHooks = create(beforeOnLivingUpdateHookTypes);
        overrideOnLivingUpdateHooks = create(overrideOnLivingUpdateHookTypes);
        afterOnLivingUpdateHooks = create(afterOnLivingUpdateHookTypes);
        isOnLivingUpdateModded = beforeOnLivingUpdateHooks != null || overrideOnLivingUpdateHooks != null || afterOnLivingUpdateHooks != null;
        beforeOnKillEntityHooks = create(beforeOnKillEntityHookTypes);
        overrideOnKillEntityHooks = create(overrideOnKillEntityHookTypes);
        afterOnKillEntityHooks = create(afterOnKillEntityHookTypes);
        isOnKillEntityModded = beforeOnKillEntityHooks != null || overrideOnKillEntityHooks != null || afterOnKillEntityHooks != null;
        beforeOnUpdateHooks = create(beforeOnUpdateHookTypes);
        overrideOnUpdateHooks = create(overrideOnUpdateHookTypes);
        afterOnUpdateHooks = create(afterOnUpdateHookTypes);
        isOnUpdateModded = beforeOnUpdateHooks != null || overrideOnUpdateHooks != null || afterOnUpdateHooks != null;
        beforeOnUpdateEntityHooks = create(beforeOnUpdateEntityHookTypes);
        overrideOnUpdateEntityHooks = create(overrideOnUpdateEntityHookTypes);
        afterOnUpdateEntityHooks = create(afterOnUpdateEntityHookTypes);
        isOnUpdateEntityModded = beforeOnUpdateEntityHooks != null || overrideOnUpdateEntityHooks != null || afterOnUpdateEntityHooks != null;
        beforeReadEntityFromNBTHooks = create(beforeReadEntityFromNBTHookTypes);
        overrideReadEntityFromNBTHooks = create(overrideReadEntityFromNBTHookTypes);
        afterReadEntityFromNBTHooks = create(afterReadEntityFromNBTHookTypes);
        isReadEntityFromNBTModded = beforeReadEntityFromNBTHooks != null || overrideReadEntityFromNBTHooks != null || afterReadEntityFromNBTHooks != null;
        beforeSetDeadHooks = create(beforeSetDeadHookTypes);
        overrideSetDeadHooks = create(overrideSetDeadHookTypes);
        afterSetDeadHooks = create(afterSetDeadHookTypes);
        isSetDeadModded = beforeSetDeadHooks != null || overrideSetDeadHooks != null || afterSetDeadHooks != null;
        beforeSetPositionHooks = create(beforeSetPositionHookTypes);
        overrideSetPositionHooks = create(overrideSetPositionHookTypes);
        afterSetPositionHooks = create(afterSetPositionHookTypes);
        isSetPositionModded = beforeSetPositionHooks != null || overrideSetPositionHooks != null || afterSetPositionHooks != null;
        beforeUpdateEntityActionStateHooks = create(beforeUpdateEntityActionStateHookTypes);
        overrideUpdateEntityActionStateHooks = create(overrideUpdateEntityActionStateHookTypes);
        afterUpdateEntityActionStateHooks = create(afterUpdateEntityActionStateHookTypes);
        isUpdateEntityActionStateModded = beforeUpdateEntityActionStateHooks != null || overrideUpdateEntityActionStateHooks != null || afterUpdateEntityActionStateHooks != null;
        beforeWriteEntityToNBTHooks = create(beforeWriteEntityToNBTHookTypes);
        overrideWriteEntityToNBTHooks = create(overrideWriteEntityToNBTHookTypes);
        afterWriteEntityToNBTHooks = create(afterWriteEntityToNBTHookTypes);
        isWriteEntityToNBTModded = beforeWriteEntityToNBTHooks != null || overrideWriteEntityToNBTHooks != null || afterWriteEntityToNBTHooks != null;
    }

    private PlayerBase[] create(List list)
    {
        if (list.isEmpty())
        {
            return null;
        }

        PlayerBase aplayerbase[] = new PlayerBase[list.size()];

        for (int i = 0; i < aplayerbase.length; i++)
        {
            aplayerbase[i] = getPlayerBase((String)list.get(i));
        }

        return aplayerbase;
    }

    private void beforeLocalConstructing(MinecraftServer minecraftserver, World world, String s, ItemInWorldManager iteminworldmanager)
    {
        if (beforeLocalConstructingHooks != null)
        {
            for (int i = beforeLocalConstructingHooks.length - 1; i >= 0; i--)
            {
                beforeLocalConstructingHooks[i].beforeLocalConstructing(minecraftserver, world, s, iteminworldmanager);
            }
        }
    }

    private void afterLocalConstructing(MinecraftServer minecraftserver, World world, String s, ItemInWorldManager iteminworldmanager)
    {
        if (afterLocalConstructingHooks != null)
        {
            for (int i = 0; i < afterLocalConstructingHooks.length; i++)
            {
                afterLocalConstructingHooks[i].afterLocalConstructing(minecraftserver, world, s, iteminworldmanager);
            }
        }
    }

    public PlayerBase getPlayerBase(String s)
    {
        return (PlayerBase)allBaseObjects.get(s);
    }

    public Set getPlayerBaseIds()
    {
        return unmodifiableAllBaseIds;
    }

    protected static boolean attackEntityFrom(EntityPlayerMP entityplayermp, DamageSource damagesource, int i)
    {
        boolean flag;

        if (entityplayermp.playerAPI != null)
        {
            flag = entityplayermp.playerAPI.attackEntityFrom(damagesource, i);
        }
        else
        {
            flag = entityplayermp.localAttackEntityFrom(damagesource, i);
        }

        return flag;
    }

    protected boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        if (beforeAttackEntityFromHooks != null)
        {
            for (int j = beforeAttackEntityFromHooks.length - 1; j >= 0; j--)
            {
                beforeAttackEntityFromHooks[j].beforeAttackEntityFrom(damagesource, i);
            }
        }

        boolean flag;

        if (overrideAttackEntityFromHooks != null)
        {
            flag = overrideAttackEntityFromHooks[overrideAttackEntityFromHooks.length - 1].attackEntityFrom(damagesource, i);
        }
        else
        {
            flag = player.localAttackEntityFrom(damagesource, i);
        }

        if (afterAttackEntityFromHooks != null)
        {
            for (int k = 0; k < afterAttackEntityFromHooks.length; k++)
            {
                afterAttackEntityFromHooks[k].afterAttackEntityFrom(damagesource, i);
            }
        }

        return flag;
    }

    protected PlayerBase GetOverwrittenAttackEntityFrom(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideAttackEntityFromHooks.length; i++)
        {
            if (overrideAttackEntityFromHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideAttackEntityFromHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void attackTargetEntityWithCurrentItem(EntityPlayerMP entityplayermp, Entity entity)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.attackTargetEntityWithCurrentItem(entity);
        }
        else
        {
            entityplayermp.localAttackTargetEntityWithCurrentItem(entity);
        }
    }

    protected void attackTargetEntityWithCurrentItem(Entity entity)
    {
        if (beforeAttackTargetEntityWithCurrentItemHooks != null)
        {
            for (int i = beforeAttackTargetEntityWithCurrentItemHooks.length - 1; i >= 0; i--)
            {
                beforeAttackTargetEntityWithCurrentItemHooks[i].beforeAttackTargetEntityWithCurrentItem(entity);
            }
        }

        if (overrideAttackTargetEntityWithCurrentItemHooks != null)
        {
            overrideAttackTargetEntityWithCurrentItemHooks[overrideAttackTargetEntityWithCurrentItemHooks.length - 1].attackTargetEntityWithCurrentItem(entity);
        }
        else
        {
            player.localAttackTargetEntityWithCurrentItem(entity);
        }

        if (afterAttackTargetEntityWithCurrentItemHooks != null)
        {
            for (int j = 0; j < afterAttackTargetEntityWithCurrentItemHooks.length; j++)
            {
                afterAttackTargetEntityWithCurrentItemHooks[j].afterAttackTargetEntityWithCurrentItem(entity);
            }
        }
    }

    protected PlayerBase GetOverwrittenAttackTargetEntityWithCurrentItem(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideAttackTargetEntityWithCurrentItemHooks.length; i++)
        {
            if (overrideAttackTargetEntityWithCurrentItemHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideAttackTargetEntityWithCurrentItemHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static boolean canHarvestBlock(EntityPlayerMP entityplayermp, Block block)
    {
        boolean flag;

        if (entityplayermp.playerAPI != null)
        {
            flag = entityplayermp.playerAPI.canHarvestBlock(block);
        }
        else
        {
            flag = entityplayermp.localCanHarvestBlock(block);
        }

        return flag;
    }

    protected boolean canHarvestBlock(Block block)
    {
        if (beforeCanHarvestBlockHooks != null)
        {
            for (int i = beforeCanHarvestBlockHooks.length - 1; i >= 0; i--)
            {
                beforeCanHarvestBlockHooks[i].beforeCanHarvestBlock(block);
            }
        }

        boolean flag;

        if (overrideCanHarvestBlockHooks != null)
        {
            flag = overrideCanHarvestBlockHooks[overrideCanHarvestBlockHooks.length - 1].canHarvestBlock(block);
        }
        else
        {
            flag = player.localCanHarvestBlock(block);
        }

        if (afterCanHarvestBlockHooks != null)
        {
            for (int j = 0; j < afterCanHarvestBlockHooks.length; j++)
            {
                afterCanHarvestBlockHooks[j].afterCanHarvestBlock(block);
            }
        }

        return flag;
    }

    protected PlayerBase GetOverwrittenCanHarvestBlock(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideCanHarvestBlockHooks.length; i++)
        {
            if (overrideCanHarvestBlockHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideCanHarvestBlockHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static boolean canPlayerEdit(EntityPlayerMP entityplayermp, int i, int j, int k)
    {
        boolean flag;

        if (entityplayermp.playerAPI != null)
        {
            flag = entityplayermp.playerAPI.canPlayerEdit(i, j, k);
        }
        else
        {
            flag = entityplayermp.localCanPlayerEdit(i, j, k);
        }

        return flag;
    }

    protected boolean canPlayerEdit(int i, int j, int k)
    {
        if (beforeCanPlayerEditHooks != null)
        {
            for (int l = beforeCanPlayerEditHooks.length - 1; l >= 0; l--)
            {
                beforeCanPlayerEditHooks[l].beforeCanPlayerEdit(i, j, k);
            }
        }

        boolean flag;

        if (overrideCanPlayerEditHooks != null)
        {
            flag = overrideCanPlayerEditHooks[overrideCanPlayerEditHooks.length - 1].canPlayerEdit(i, j, k);
        }
        else
        {
            flag = player.localCanPlayerEdit(i, j, k);
        }

        if (afterCanPlayerEditHooks != null)
        {
            for (int i1 = 0; i1 < afterCanPlayerEditHooks.length; i1++)
            {
                afterCanPlayerEditHooks[i1].afterCanPlayerEdit(i, j, k);
            }
        }

        return flag;
    }

    protected PlayerBase GetOverwrittenCanPlayerEdit(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideCanPlayerEditHooks.length; i++)
        {
            if (overrideCanPlayerEditHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideCanPlayerEditHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static boolean canTriggerWalking(EntityPlayerMP entityplayermp)
    {
        boolean flag;

        if (entityplayermp.playerAPI != null)
        {
            flag = entityplayermp.playerAPI.canTriggerWalking();
        }
        else
        {
            flag = entityplayermp.localCanTriggerWalking();
        }

        return flag;
    }

    protected boolean canTriggerWalking()
    {
        if (beforeCanTriggerWalkingHooks != null)
        {
            for (int i = beforeCanTriggerWalkingHooks.length - 1; i >= 0; i--)
            {
                beforeCanTriggerWalkingHooks[i].beforeCanTriggerWalking();
            }
        }

        boolean flag;

        if (overrideCanTriggerWalkingHooks != null)
        {
            flag = overrideCanTriggerWalkingHooks[overrideCanTriggerWalkingHooks.length - 1].canTriggerWalking();
        }
        else
        {
            flag = player.localCanTriggerWalking();
        }

        if (afterCanTriggerWalkingHooks != null)
        {
            for (int j = 0; j < afterCanTriggerWalkingHooks.length; j++)
            {
                afterCanTriggerWalkingHooks[j].afterCanTriggerWalking();
            }
        }

        return flag;
    }

    protected PlayerBase GetOverwrittenCanTriggerWalking(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideCanTriggerWalkingHooks.length; i++)
        {
            if (overrideCanTriggerWalkingHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideCanTriggerWalkingHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void damageEntity(EntityPlayerMP entityplayermp, DamageSource damagesource, int i)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.damageEntity(damagesource, i);
        }
        else
        {
            entityplayermp.localDamageEntity(damagesource, i);
        }
    }

    protected void damageEntity(DamageSource damagesource, int i)
    {
        if (beforeDamageEntityHooks != null)
        {
            for (int j = beforeDamageEntityHooks.length - 1; j >= 0; j--)
            {
                beforeDamageEntityHooks[j].beforeDamageEntity(damagesource, i);
            }
        }

        if (overrideDamageEntityHooks != null)
        {
            overrideDamageEntityHooks[overrideDamageEntityHooks.length - 1].damageEntity(damagesource, i);
        }
        else
        {
            player.localDamageEntity(damagesource, i);
        }

        if (afterDamageEntityHooks != null)
        {
            for (int k = 0; k < afterDamageEntityHooks.length; k++)
            {
                afterDamageEntityHooks[k].afterDamageEntity(damagesource, i);
            }
        }
    }

    protected PlayerBase GetOverwrittenDamageEntity(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideDamageEntityHooks.length; i++)
        {
            if (overrideDamageEntityHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideDamageEntityHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void displayGUIChest(EntityPlayerMP entityplayermp, IInventory iinventory)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.displayGUIChest(iinventory);
        }
        else
        {
            entityplayermp.localDisplayGUIChest(iinventory);
        }
    }

    protected void displayGUIChest(IInventory iinventory)
    {
        if (beforeDisplayGUIChestHooks != null)
        {
            for (int i = beforeDisplayGUIChestHooks.length - 1; i >= 0; i--)
            {
                beforeDisplayGUIChestHooks[i].beforeDisplayGUIChest(iinventory);
            }
        }

        if (overrideDisplayGUIChestHooks != null)
        {
            overrideDisplayGUIChestHooks[overrideDisplayGUIChestHooks.length - 1].displayGUIChest(iinventory);
        }
        else
        {
            player.localDisplayGUIChest(iinventory);
        }

        if (afterDisplayGUIChestHooks != null)
        {
            for (int j = 0; j < afterDisplayGUIChestHooks.length; j++)
            {
                afterDisplayGUIChestHooks[j].afterDisplayGUIChest(iinventory);
            }
        }
    }

    protected PlayerBase GetOverwrittenDisplayGUIChest(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideDisplayGUIChestHooks.length; i++)
        {
            if (overrideDisplayGUIChestHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideDisplayGUIChestHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void displayGUIDispenser(EntityPlayerMP entityplayermp, TileEntityDispenser tileentitydispenser)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.displayGUIDispenser(tileentitydispenser);
        }
        else
        {
            entityplayermp.localDisplayGUIDispenser(tileentitydispenser);
        }
    }

    protected void displayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
        if (beforeDisplayGUIDispenserHooks != null)
        {
            for (int i = beforeDisplayGUIDispenserHooks.length - 1; i >= 0; i--)
            {
                beforeDisplayGUIDispenserHooks[i].beforeDisplayGUIDispenser(tileentitydispenser);
            }
        }

        if (overrideDisplayGUIDispenserHooks != null)
        {
            overrideDisplayGUIDispenserHooks[overrideDisplayGUIDispenserHooks.length - 1].displayGUIDispenser(tileentitydispenser);
        }
        else
        {
            player.localDisplayGUIDispenser(tileentitydispenser);
        }

        if (afterDisplayGUIDispenserHooks != null)
        {
            for (int j = 0; j < afterDisplayGUIDispenserHooks.length; j++)
            {
                afterDisplayGUIDispenserHooks[j].afterDisplayGUIDispenser(tileentitydispenser);
            }
        }
    }

    protected PlayerBase GetOverwrittenDisplayGUIDispenser(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideDisplayGUIDispenserHooks.length; i++)
        {
            if (overrideDisplayGUIDispenserHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideDisplayGUIDispenserHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void displayGUIFurnace(EntityPlayerMP entityplayermp, TileEntityFurnace tileentityfurnace)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.displayGUIFurnace(tileentityfurnace);
        }
        else
        {
            entityplayermp.localDisplayGUIFurnace(tileentityfurnace);
        }
    }

    protected void displayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
        if (beforeDisplayGUIFurnaceHooks != null)
        {
            for (int i = beforeDisplayGUIFurnaceHooks.length - 1; i >= 0; i--)
            {
                beforeDisplayGUIFurnaceHooks[i].beforeDisplayGUIFurnace(tileentityfurnace);
            }
        }

        if (overrideDisplayGUIFurnaceHooks != null)
        {
            overrideDisplayGUIFurnaceHooks[overrideDisplayGUIFurnaceHooks.length - 1].displayGUIFurnace(tileentityfurnace);
        }
        else
        {
            player.localDisplayGUIFurnace(tileentityfurnace);
        }

        if (afterDisplayGUIFurnaceHooks != null)
        {
            for (int j = 0; j < afterDisplayGUIFurnaceHooks.length; j++)
            {
                afterDisplayGUIFurnaceHooks[j].afterDisplayGUIFurnace(tileentityfurnace);
            }
        }
    }

    protected PlayerBase GetOverwrittenDisplayGUIFurnace(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideDisplayGUIFurnaceHooks.length; i++)
        {
            if (overrideDisplayGUIFurnaceHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideDisplayGUIFurnaceHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void displayWorkbenchGUI(EntityPlayerMP entityplayermp, int i, int j, int k)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.displayWorkbenchGUI(i, j, k);
        }
        else
        {
            entityplayermp.localDisplayWorkbenchGUI(i, j, k);
        }
    }

    protected void displayWorkbenchGUI(int i, int j, int k)
    {
        if (beforeDisplayWorkbenchGUIHooks != null)
        {
            for (int l = beforeDisplayWorkbenchGUIHooks.length - 1; l >= 0; l--)
            {
                beforeDisplayWorkbenchGUIHooks[l].beforeDisplayWorkbenchGUI(i, j, k);
            }
        }

        if (overrideDisplayWorkbenchGUIHooks != null)
        {
            overrideDisplayWorkbenchGUIHooks[overrideDisplayWorkbenchGUIHooks.length - 1].displayWorkbenchGUI(i, j, k);
        }
        else
        {
            player.localDisplayWorkbenchGUI(i, j, k);
        }

        if (afterDisplayWorkbenchGUIHooks != null)
        {
            for (int i1 = 0; i1 < afterDisplayWorkbenchGUIHooks.length; i1++)
            {
                afterDisplayWorkbenchGUIHooks[i1].afterDisplayWorkbenchGUI(i, j, k);
            }
        }
    }

    protected PlayerBase GetOverwrittenDisplayWorkbenchGUI(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideDisplayWorkbenchGUIHooks.length; i++)
        {
            if (overrideDisplayWorkbenchGUIHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideDisplayWorkbenchGUIHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static EntityItem dropOneItem(EntityPlayerMP entityplayermp)
    {
        EntityItem entityitem;

        if (entityplayermp.playerAPI != null)
        {
            entityitem = entityplayermp.playerAPI.dropOneItem();
        }
        else
        {
            entityitem = entityplayermp.localDropOneItem();
        }

        return entityitem;
    }

    protected EntityItem dropOneItem()
    {
        if (beforeDropOneItemHooks != null)
        {
            for (int i = beforeDropOneItemHooks.length - 1; i >= 0; i--)
            {
                beforeDropOneItemHooks[i].beforeDropOneItem();
            }
        }

        EntityItem entityitem;

        if (overrideDropOneItemHooks != null)
        {
            entityitem = overrideDropOneItemHooks[overrideDropOneItemHooks.length - 1].dropOneItem();
        }
        else
        {
            entityitem = player.localDropOneItem();
        }

        if (afterDropOneItemHooks != null)
        {
            for (int j = 0; j < afterDropOneItemHooks.length; j++)
            {
                afterDropOneItemHooks[j].afterDropOneItem();
            }
        }

        return entityitem;
    }

    protected PlayerBase GetOverwrittenDropOneItem(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideDropOneItemHooks.length; i++)
        {
            if (overrideDropOneItemHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideDropOneItemHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static EntityItem dropPlayerItem(EntityPlayerMP entityplayermp, ItemStack itemstack)
    {
        EntityItem entityitem;

        if (entityplayermp.playerAPI != null)
        {
            entityitem = entityplayermp.playerAPI.dropPlayerItem(itemstack);
        }
        else
        {
            entityitem = entityplayermp.localDropPlayerItem(itemstack);
        }

        return entityitem;
    }

    protected EntityItem dropPlayerItem(ItemStack itemstack)
    {
        if (beforeDropPlayerItemHooks != null)
        {
            for (int i = beforeDropPlayerItemHooks.length - 1; i >= 0; i--)
            {
                beforeDropPlayerItemHooks[i].beforeDropPlayerItem(itemstack);
            }
        }

        EntityItem entityitem;

        if (overrideDropPlayerItemHooks != null)
        {
            entityitem = overrideDropPlayerItemHooks[overrideDropPlayerItemHooks.length - 1].dropPlayerItem(itemstack);
        }
        else
        {
            entityitem = player.localDropPlayerItem(itemstack);
        }

        if (afterDropPlayerItemHooks != null)
        {
            for (int j = 0; j < afterDropPlayerItemHooks.length; j++)
            {
                afterDropPlayerItemHooks[j].afterDropPlayerItem(itemstack);
            }
        }

        return entityitem;
    }

    protected PlayerBase GetOverwrittenDropPlayerItem(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideDropPlayerItemHooks.length; i++)
        {
            if (overrideDropPlayerItemHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideDropPlayerItemHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void fall(EntityPlayerMP entityplayermp, float f)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.fall(f);
        }
        else
        {
            entityplayermp.localFall(f);
        }
    }

    protected void fall(float f)
    {
        if (beforeFallHooks != null)
        {
            for (int i = beforeFallHooks.length - 1; i >= 0; i--)
            {
                beforeFallHooks[i].beforeFall(f);
            }
        }

        if (overrideFallHooks != null)
        {
            overrideFallHooks[overrideFallHooks.length - 1].fall(f);
        }
        else
        {
            player.localFall(f);
        }

        if (afterFallHooks != null)
        {
            for (int j = 0; j < afterFallHooks.length; j++)
            {
                afterFallHooks[j].afterFall(f);
            }
        }
    }

    protected PlayerBase GetOverwrittenFall(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideFallHooks.length; i++)
        {
            if (overrideFallHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideFallHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static float getCurrentPlayerStrVsBlock(EntityPlayerMP entityplayermp, Block block)
    {
        float f;

        if (entityplayermp.playerAPI != null)
        {
            f = entityplayermp.playerAPI.getCurrentPlayerStrVsBlock(block);
        }
        else
        {
            f = entityplayermp.localGetCurrentPlayerStrVsBlock(block);
        }

        return f;
    }

    protected float getCurrentPlayerStrVsBlock(Block block)
    {
        if (beforeGetCurrentPlayerStrVsBlockHooks != null)
        {
            for (int i = beforeGetCurrentPlayerStrVsBlockHooks.length - 1; i >= 0; i--)
            {
                beforeGetCurrentPlayerStrVsBlockHooks[i].beforeGetCurrentPlayerStrVsBlock(block);
            }
        }

        float f;

        if (overrideGetCurrentPlayerStrVsBlockHooks != null)
        {
            f = overrideGetCurrentPlayerStrVsBlockHooks[overrideGetCurrentPlayerStrVsBlockHooks.length - 1].getCurrentPlayerStrVsBlock(block);
        }
        else
        {
            f = player.localGetCurrentPlayerStrVsBlock(block);
        }

        if (afterGetCurrentPlayerStrVsBlockHooks != null)
        {
            for (int j = 0; j < afterGetCurrentPlayerStrVsBlockHooks.length; j++)
            {
                afterGetCurrentPlayerStrVsBlockHooks[j].afterGetCurrentPlayerStrVsBlock(block);
            }
        }

        return f;
    }

    protected PlayerBase GetOverwrittenGetCurrentPlayerStrVsBlock(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideGetCurrentPlayerStrVsBlockHooks.length; i++)
        {
            if (overrideGetCurrentPlayerStrVsBlockHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideGetCurrentPlayerStrVsBlockHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static double getDistanceSq(EntityPlayerMP entityplayermp, double d, double d1, double d2)
    {
        double d3;

        if (entityplayermp.playerAPI != null)
        {
            d3 = entityplayermp.playerAPI.getDistanceSq(d, d1, d2);
        }
        else
        {
            d3 = entityplayermp.localGetDistanceSq(d, d1, d2);
        }

        return d3;
    }

    protected double getDistanceSq(double d, double d1, double d2)
    {
        if (beforeGetDistanceSqHooks != null)
        {
            for (int i = beforeGetDistanceSqHooks.length - 1; i >= 0; i--)
            {
                beforeGetDistanceSqHooks[i].beforeGetDistanceSq(d, d1, d2);
            }
        }

        double d3;

        if (overrideGetDistanceSqHooks != null)
        {
            d3 = overrideGetDistanceSqHooks[overrideGetDistanceSqHooks.length - 1].getDistanceSq(d, d1, d2);
        }
        else
        {
            d3 = player.localGetDistanceSq(d, d1, d2);
        }

        if (afterGetDistanceSqHooks != null)
        {
            for (int j = 0; j < afterGetDistanceSqHooks.length; j++)
            {
                afterGetDistanceSqHooks[j].afterGetDistanceSq(d, d1, d2);
            }
        }

        return d3;
    }

    protected PlayerBase GetOverwrittenGetDistanceSq(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideGetDistanceSqHooks.length; i++)
        {
            if (overrideGetDistanceSqHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideGetDistanceSqHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static float getBrightness(EntityPlayerMP entityplayermp, float f)
    {
        float f1;

        if (entityplayermp.playerAPI != null)
        {
            f1 = entityplayermp.playerAPI.getBrightness(f);
        }
        else
        {
            f1 = entityplayermp.localGetBrightness(f);
        }

        return f1;
    }

    protected float getBrightness(float f)
    {
        if (beforeGetBrightnessHooks != null)
        {
            for (int i = beforeGetBrightnessHooks.length - 1; i >= 0; i--)
            {
                beforeGetBrightnessHooks[i].beforeGetBrightness(f);
            }
        }

        float f1;

        if (overrideGetBrightnessHooks != null)
        {
            f1 = overrideGetBrightnessHooks[overrideGetBrightnessHooks.length - 1].getBrightness(f);
        }
        else
        {
            f1 = player.localGetBrightness(f);
        }

        if (afterGetBrightnessHooks != null)
        {
            for (int j = 0; j < afterGetBrightnessHooks.length; j++)
            {
                afterGetBrightnessHooks[j].afterGetBrightness(f);
            }
        }

        return f1;
    }

    protected PlayerBase GetOverwrittenGetBrightness(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideGetBrightnessHooks.length; i++)
        {
            if (overrideGetBrightnessHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideGetBrightnessHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static float getEyeHeight(EntityPlayerMP entityplayermp)
    {
        float f;

        if (entityplayermp.playerAPI != null)
        {
            f = entityplayermp.playerAPI.getEyeHeight();
        }
        else
        {
            f = entityplayermp.localGetEyeHeight();
        }

        return f;
    }

    protected float getEyeHeight()
    {
        if (beforeGetEyeHeightHooks != null)
        {
            for (int i = beforeGetEyeHeightHooks.length - 1; i >= 0; i--)
            {
                beforeGetEyeHeightHooks[i].beforeGetEyeHeight();
            }
        }

        float f;

        if (overrideGetEyeHeightHooks != null)
        {
            f = overrideGetEyeHeightHooks[overrideGetEyeHeightHooks.length - 1].getEyeHeight();
        }
        else
        {
            f = player.localGetEyeHeight();
        }

        if (afterGetEyeHeightHooks != null)
        {
            for (int j = 0; j < afterGetEyeHeightHooks.length; j++)
            {
                afterGetEyeHeightHooks[j].afterGetEyeHeight();
            }
        }

        return f;
    }

    protected PlayerBase GetOverwrittenGetEyeHeight(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideGetEyeHeightHooks.length; i++)
        {
            if (overrideGetEyeHeightHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideGetEyeHeightHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void heal(EntityPlayerMP entityplayermp, int i)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.heal(i);
        }
        else
        {
            entityplayermp.localHeal(i);
        }
    }

    protected void heal(int i)
    {
        if (beforeHealHooks != null)
        {
            for (int j = beforeHealHooks.length - 1; j >= 0; j--)
            {
                beforeHealHooks[j].beforeHeal(i);
            }
        }

        if (overrideHealHooks != null)
        {
            overrideHealHooks[overrideHealHooks.length - 1].heal(i);
        }
        else
        {
            player.localHeal(i);
        }

        if (afterHealHooks != null)
        {
            for (int k = 0; k < afterHealHooks.length; k++)
            {
                afterHealHooks[k].afterHeal(i);
            }
        }
    }

    protected PlayerBase GetOverwrittenHeal(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideHealHooks.length; i++)
        {
            if (overrideHealHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideHealHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static boolean interact(EntityPlayerMP entityplayermp, EntityPlayer entityplayer)
    {
        boolean flag;

        if (entityplayermp.playerAPI != null)
        {
            flag = entityplayermp.playerAPI.interact(entityplayer);
        }
        else
        {
            flag = entityplayermp.localInteract(entityplayer);
        }

        return flag;
    }

    protected boolean interact(EntityPlayer entityplayer)
    {
        if (beforeInteractHooks != null)
        {
            for (int i = beforeInteractHooks.length - 1; i >= 0; i--)
            {
                beforeInteractHooks[i].beforeInteract(entityplayer);
            }
        }

        boolean flag;

        if (overrideInteractHooks != null)
        {
            flag = overrideInteractHooks[overrideInteractHooks.length - 1].interact(entityplayer);
        }
        else
        {
            flag = player.localInteract(entityplayer);
        }

        if (afterInteractHooks != null)
        {
            for (int j = 0; j < afterInteractHooks.length; j++)
            {
                afterInteractHooks[j].afterInteract(entityplayer);
            }
        }

        return flag;
    }

    protected PlayerBase GetOverwrittenInteract(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideInteractHooks.length; i++)
        {
            if (overrideInteractHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideInteractHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static boolean isEntityInsideOpaqueBlock(EntityPlayerMP entityplayermp)
    {
        boolean flag;

        if (entityplayermp.playerAPI != null)
        {
            flag = entityplayermp.playerAPI.isEntityInsideOpaqueBlock();
        }
        else
        {
            flag = entityplayermp.localIsEntityInsideOpaqueBlock();
        }

        return flag;
    }

    protected boolean isEntityInsideOpaqueBlock()
    {
        if (beforeIsEntityInsideOpaqueBlockHooks != null)
        {
            for (int i = beforeIsEntityInsideOpaqueBlockHooks.length - 1; i >= 0; i--)
            {
                beforeIsEntityInsideOpaqueBlockHooks[i].beforeIsEntityInsideOpaqueBlock();
            }
        }

        boolean flag;

        if (overrideIsEntityInsideOpaqueBlockHooks != null)
        {
            flag = overrideIsEntityInsideOpaqueBlockHooks[overrideIsEntityInsideOpaqueBlockHooks.length - 1].isEntityInsideOpaqueBlock();
        }
        else
        {
            flag = player.localIsEntityInsideOpaqueBlock();
        }

        if (afterIsEntityInsideOpaqueBlockHooks != null)
        {
            for (int j = 0; j < afterIsEntityInsideOpaqueBlockHooks.length; j++)
            {
                afterIsEntityInsideOpaqueBlockHooks[j].afterIsEntityInsideOpaqueBlock();
            }
        }

        return flag;
    }

    protected PlayerBase GetOverwrittenIsEntityInsideOpaqueBlock(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideIsEntityInsideOpaqueBlockHooks.length; i++)
        {
            if (overrideIsEntityInsideOpaqueBlockHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideIsEntityInsideOpaqueBlockHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static boolean isInWater(EntityPlayerMP entityplayermp)
    {
        boolean flag;

        if (entityplayermp.playerAPI != null)
        {
            flag = entityplayermp.playerAPI.isInWater();
        }
        else
        {
            flag = entityplayermp.localIsInWater();
        }

        return flag;
    }

    protected boolean isInWater()
    {
        if (beforeIsInWaterHooks != null)
        {
            for (int i = beforeIsInWaterHooks.length - 1; i >= 0; i--)
            {
                beforeIsInWaterHooks[i].beforeIsInWater();
            }
        }

        boolean flag;

        if (overrideIsInWaterHooks != null)
        {
            flag = overrideIsInWaterHooks[overrideIsInWaterHooks.length - 1].isInWater();
        }
        else
        {
            flag = player.localIsInWater();
        }

        if (afterIsInWaterHooks != null)
        {
            for (int j = 0; j < afterIsInWaterHooks.length; j++)
            {
                afterIsInWaterHooks[j].afterIsInWater();
            }
        }

        return flag;
    }

    protected PlayerBase GetOverwrittenIsInWater(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideIsInWaterHooks.length; i++)
        {
            if (overrideIsInWaterHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideIsInWaterHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static boolean isInsideOfMaterial(EntityPlayerMP entityplayermp, Material material)
    {
        boolean flag;

        if (entityplayermp.playerAPI != null)
        {
            flag = entityplayermp.playerAPI.isInsideOfMaterial(material);
        }
        else
        {
            flag = entityplayermp.localIsInsideOfMaterial(material);
        }

        return flag;
    }

    protected boolean isInsideOfMaterial(Material material)
    {
        if (beforeIsInsideOfMaterialHooks != null)
        {
            for (int i = beforeIsInsideOfMaterialHooks.length - 1; i >= 0; i--)
            {
                beforeIsInsideOfMaterialHooks[i].beforeIsInsideOfMaterial(material);
            }
        }

        boolean flag;

        if (overrideIsInsideOfMaterialHooks != null)
        {
            flag = overrideIsInsideOfMaterialHooks[overrideIsInsideOfMaterialHooks.length - 1].isInsideOfMaterial(material);
        }
        else
        {
            flag = player.localIsInsideOfMaterial(material);
        }

        if (afterIsInsideOfMaterialHooks != null)
        {
            for (int j = 0; j < afterIsInsideOfMaterialHooks.length; j++)
            {
                afterIsInsideOfMaterialHooks[j].afterIsInsideOfMaterial(material);
            }
        }

        return flag;
    }

    protected PlayerBase GetOverwrittenIsInsideOfMaterial(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideIsInsideOfMaterialHooks.length; i++)
        {
            if (overrideIsInsideOfMaterialHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideIsInsideOfMaterialHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static boolean isOnLadder(EntityPlayerMP entityplayermp)
    {
        boolean flag;

        if (entityplayermp.playerAPI != null)
        {
            flag = entityplayermp.playerAPI.isOnLadder();
        }
        else
        {
            flag = entityplayermp.localIsOnLadder();
        }

        return flag;
    }

    protected boolean isOnLadder()
    {
        if (beforeIsOnLadderHooks != null)
        {
            for (int i = beforeIsOnLadderHooks.length - 1; i >= 0; i--)
            {
                beforeIsOnLadderHooks[i].beforeIsOnLadder();
            }
        }

        boolean flag;

        if (overrideIsOnLadderHooks != null)
        {
            flag = overrideIsOnLadderHooks[overrideIsOnLadderHooks.length - 1].isOnLadder();
        }
        else
        {
            flag = player.localIsOnLadder();
        }

        if (afterIsOnLadderHooks != null)
        {
            for (int j = 0; j < afterIsOnLadderHooks.length; j++)
            {
                afterIsOnLadderHooks[j].afterIsOnLadder();
            }
        }

        return flag;
    }

    protected PlayerBase GetOverwrittenIsOnLadder(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideIsOnLadderHooks.length; i++)
        {
            if (overrideIsOnLadderHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideIsOnLadderHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static boolean isPlayerSleeping(EntityPlayerMP entityplayermp)
    {
        boolean flag;

        if (entityplayermp.playerAPI != null)
        {
            flag = entityplayermp.playerAPI.isPlayerSleeping();
        }
        else
        {
            flag = entityplayermp.localIsPlayerSleeping();
        }

        return flag;
    }

    protected boolean isPlayerSleeping()
    {
        if (beforeIsPlayerSleepingHooks != null)
        {
            for (int i = beforeIsPlayerSleepingHooks.length - 1; i >= 0; i--)
            {
                beforeIsPlayerSleepingHooks[i].beforeIsPlayerSleeping();
            }
        }

        boolean flag;

        if (overrideIsPlayerSleepingHooks != null)
        {
            flag = overrideIsPlayerSleepingHooks[overrideIsPlayerSleepingHooks.length - 1].isPlayerSleeping();
        }
        else
        {
            flag = player.localIsPlayerSleeping();
        }

        if (afterIsPlayerSleepingHooks != null)
        {
            for (int j = 0; j < afterIsPlayerSleepingHooks.length; j++)
            {
                afterIsPlayerSleepingHooks[j].afterIsPlayerSleeping();
            }
        }

        return flag;
    }

    protected PlayerBase GetOverwrittenIsPlayerSleeping(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideIsPlayerSleepingHooks.length; i++)
        {
            if (overrideIsPlayerSleepingHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideIsPlayerSleepingHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void jump(EntityPlayerMP entityplayermp)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.jump();
        }
        else
        {
            entityplayermp.localJump();
        }
    }

    protected void jump()
    {
        if (beforeJumpHooks != null)
        {
            for (int i = beforeJumpHooks.length - 1; i >= 0; i--)
            {
                beforeJumpHooks[i].beforeJump();
            }
        }

        if (overrideJumpHooks != null)
        {
            overrideJumpHooks[overrideJumpHooks.length - 1].jump();
        }
        else
        {
            player.localJump();
        }

        if (afterJumpHooks != null)
        {
            for (int j = 0; j < afterJumpHooks.length; j++)
            {
                afterJumpHooks[j].afterJump();
            }
        }
    }

    protected PlayerBase GetOverwrittenJump(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideJumpHooks.length; i++)
        {
            if (overrideJumpHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideJumpHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void moveEntity(EntityPlayerMP entityplayermp, double d, double d1, double d2)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.moveEntity(d, d1, d2);
        }
        else
        {
            entityplayermp.localMoveEntity(d, d1, d2);
        }
    }

    protected void moveEntity(double d, double d1, double d2)
    {
        if (beforeMoveEntityHooks != null)
        {
            for (int i = beforeMoveEntityHooks.length - 1; i >= 0; i--)
            {
                beforeMoveEntityHooks[i].beforeMoveEntity(d, d1, d2);
            }
        }

        if (overrideMoveEntityHooks != null)
        {
            overrideMoveEntityHooks[overrideMoveEntityHooks.length - 1].moveEntity(d, d1, d2);
        }
        else
        {
            player.localMoveEntity(d, d1, d2);
        }

        if (afterMoveEntityHooks != null)
        {
            for (int j = 0; j < afterMoveEntityHooks.length; j++)
            {
                afterMoveEntityHooks[j].afterMoveEntity(d, d1, d2);
            }
        }
    }

    protected PlayerBase GetOverwrittenMoveEntity(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideMoveEntityHooks.length; i++)
        {
            if (overrideMoveEntityHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideMoveEntityHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void moveEntityWithHeading(EntityPlayerMP entityplayermp, float f, float f1)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.moveEntityWithHeading(f, f1);
        }
        else
        {
            entityplayermp.localMoveEntityWithHeading(f, f1);
        }
    }

    protected void moveEntityWithHeading(float f, float f1)
    {
        if (beforeMoveEntityWithHeadingHooks != null)
        {
            for (int i = beforeMoveEntityWithHeadingHooks.length - 1; i >= 0; i--)
            {
                beforeMoveEntityWithHeadingHooks[i].beforeMoveEntityWithHeading(f, f1);
            }
        }

        if (overrideMoveEntityWithHeadingHooks != null)
        {
            overrideMoveEntityWithHeadingHooks[overrideMoveEntityWithHeadingHooks.length - 1].moveEntityWithHeading(f, f1);
        }
        else
        {
            player.localMoveEntityWithHeading(f, f1);
        }

        if (afterMoveEntityWithHeadingHooks != null)
        {
            for (int j = 0; j < afterMoveEntityWithHeadingHooks.length; j++)
            {
                afterMoveEntityWithHeadingHooks[j].afterMoveEntityWithHeading(f, f1);
            }
        }
    }

    protected PlayerBase GetOverwrittenMoveEntityWithHeading(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideMoveEntityWithHeadingHooks.length; i++)
        {
            if (overrideMoveEntityWithHeadingHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideMoveEntityWithHeadingHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void moveFlying(EntityPlayerMP entityplayermp, float f, float f1, float f2)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.moveFlying(f, f1, f2);
        }
        else
        {
            entityplayermp.localMoveFlying(f, f1, f2);
        }
    }

    protected void moveFlying(float f, float f1, float f2)
    {
        if (beforeMoveFlyingHooks != null)
        {
            for (int i = beforeMoveFlyingHooks.length - 1; i >= 0; i--)
            {
                beforeMoveFlyingHooks[i].beforeMoveFlying(f, f1, f2);
            }
        }

        if (overrideMoveFlyingHooks != null)
        {
            overrideMoveFlyingHooks[overrideMoveFlyingHooks.length - 1].moveFlying(f, f1, f2);
        }
        else
        {
            player.localMoveFlying(f, f1, f2);
        }

        if (afterMoveFlyingHooks != null)
        {
            for (int j = 0; j < afterMoveFlyingHooks.length; j++)
            {
                afterMoveFlyingHooks[j].afterMoveFlying(f, f1, f2);
            }
        }
    }

    protected PlayerBase GetOverwrittenMoveFlying(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideMoveFlyingHooks.length; i++)
        {
            if (overrideMoveFlyingHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideMoveFlyingHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void onDeath(EntityPlayerMP entityplayermp, DamageSource damagesource)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.onDeath(damagesource);
        }
        else
        {
            entityplayermp.localOnDeath(damagesource);
        }
    }

    protected void onDeath(DamageSource damagesource)
    {
        if (beforeOnDeathHooks != null)
        {
            for (int i = beforeOnDeathHooks.length - 1; i >= 0; i--)
            {
                beforeOnDeathHooks[i].beforeOnDeath(damagesource);
            }
        }

        if (overrideOnDeathHooks != null)
        {
            overrideOnDeathHooks[overrideOnDeathHooks.length - 1].onDeath(damagesource);
        }
        else
        {
            player.localOnDeath(damagesource);
        }

        if (afterOnDeathHooks != null)
        {
            for (int j = 0; j < afterOnDeathHooks.length; j++)
            {
                afterOnDeathHooks[j].afterOnDeath(damagesource);
            }
        }
    }

    protected PlayerBase GetOverwrittenOnDeath(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideOnDeathHooks.length; i++)
        {
            if (overrideOnDeathHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideOnDeathHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void onLivingUpdate(EntityPlayerMP entityplayermp)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.onLivingUpdate();
        }
        else
        {
            entityplayermp.localOnLivingUpdate();
        }
    }

    protected void onLivingUpdate()
    {
        if (beforeOnLivingUpdateHooks != null)
        {
            for (int i = beforeOnLivingUpdateHooks.length - 1; i >= 0; i--)
            {
                beforeOnLivingUpdateHooks[i].beforeOnLivingUpdate();
            }
        }

        if (overrideOnLivingUpdateHooks != null)
        {
            overrideOnLivingUpdateHooks[overrideOnLivingUpdateHooks.length - 1].onLivingUpdate();
        }
        else
        {
            player.localOnLivingUpdate();
        }

        if (afterOnLivingUpdateHooks != null)
        {
            for (int j = 0; j < afterOnLivingUpdateHooks.length; j++)
            {
                afterOnLivingUpdateHooks[j].afterOnLivingUpdate();
            }
        }
    }

    protected PlayerBase GetOverwrittenOnLivingUpdate(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideOnLivingUpdateHooks.length; i++)
        {
            if (overrideOnLivingUpdateHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideOnLivingUpdateHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void onKillEntity(EntityPlayerMP entityplayermp, EntityLiving entityliving)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.onKillEntity(entityliving);
        }
        else
        {
            entityplayermp.localOnKillEntity(entityliving);
        }
    }

    protected void onKillEntity(EntityLiving entityliving)
    {
        if (beforeOnKillEntityHooks != null)
        {
            for (int i = beforeOnKillEntityHooks.length - 1; i >= 0; i--)
            {
                beforeOnKillEntityHooks[i].beforeOnKillEntity(entityliving);
            }
        }

        if (overrideOnKillEntityHooks != null)
        {
            overrideOnKillEntityHooks[overrideOnKillEntityHooks.length - 1].onKillEntity(entityliving);
        }
        else
        {
            player.localOnKillEntity(entityliving);
        }

        if (afterOnKillEntityHooks != null)
        {
            for (int j = 0; j < afterOnKillEntityHooks.length; j++)
            {
                afterOnKillEntityHooks[j].afterOnKillEntity(entityliving);
            }
        }
    }

    protected PlayerBase GetOverwrittenOnKillEntity(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideOnKillEntityHooks.length; i++)
        {
            if (overrideOnKillEntityHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideOnKillEntityHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void onUpdate(EntityPlayerMP entityplayermp)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.onUpdate();
        }
        else
        {
            entityplayermp.localOnUpdate();
        }
    }

    protected void onUpdate()
    {
        if (beforeOnUpdateHooks != null)
        {
            for (int i = beforeOnUpdateHooks.length - 1; i >= 0; i--)
            {
                beforeOnUpdateHooks[i].beforeOnUpdate();
            }
        }

        if (overrideOnUpdateHooks != null)
        {
            overrideOnUpdateHooks[overrideOnUpdateHooks.length - 1].onUpdate();
        }
        else
        {
            player.localOnUpdate();
        }

        if (afterOnUpdateHooks != null)
        {
            for (int j = 0; j < afterOnUpdateHooks.length; j++)
            {
                afterOnUpdateHooks[j].afterOnUpdate();
            }
        }
    }

    protected PlayerBase GetOverwrittenOnUpdate(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideOnUpdateHooks.length; i++)
        {
            if (overrideOnUpdateHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideOnUpdateHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void onUpdateEntity(EntityPlayerMP entityplayermp, boolean flag)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.onUpdateEntity(flag);
        }
        else
        {
            entityplayermp.localOnUpdateEntity(flag);
        }
    }

    protected void onUpdateEntity(boolean flag)
    {
        if (beforeOnUpdateEntityHooks != null)
        {
            for (int i = beforeOnUpdateEntityHooks.length - 1; i >= 0; i--)
            {
                beforeOnUpdateEntityHooks[i].beforeOnUpdateEntity(flag);
            }
        }

        if (overrideOnUpdateEntityHooks != null)
        {
            overrideOnUpdateEntityHooks[overrideOnUpdateEntityHooks.length - 1].onUpdateEntity(flag);
        }
        else
        {
            player.localOnUpdateEntity(flag);
        }

        if (afterOnUpdateEntityHooks != null)
        {
            for (int j = 0; j < afterOnUpdateEntityHooks.length; j++)
            {
                afterOnUpdateEntityHooks[j].afterOnUpdateEntity(flag);
            }
        }
    }

    protected PlayerBase GetOverwrittenOnUpdateEntity(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideOnUpdateEntityHooks.length; i++)
        {
            if (overrideOnUpdateEntityHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideOnUpdateEntityHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void readEntityFromNBT(EntityPlayerMP entityplayermp, NBTTagCompound nbttagcompound)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.readEntityFromNBT(nbttagcompound);
        }
        else
        {
            entityplayermp.localReadEntityFromNBT(nbttagcompound);
        }
    }

    protected void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        if (beforeReadEntityFromNBTHooks != null)
        {
            for (int i = beforeReadEntityFromNBTHooks.length - 1; i >= 0; i--)
            {
                beforeReadEntityFromNBTHooks[i].beforeReadEntityFromNBT(nbttagcompound);
            }
        }

        if (overrideReadEntityFromNBTHooks != null)
        {
            overrideReadEntityFromNBTHooks[overrideReadEntityFromNBTHooks.length - 1].readEntityFromNBT(nbttagcompound);
        }
        else
        {
            player.localReadEntityFromNBT(nbttagcompound);
        }

        if (afterReadEntityFromNBTHooks != null)
        {
            for (int j = 0; j < afterReadEntityFromNBTHooks.length; j++)
            {
                afterReadEntityFromNBTHooks[j].afterReadEntityFromNBT(nbttagcompound);
            }
        }
    }

    protected PlayerBase GetOverwrittenReadEntityFromNBT(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideReadEntityFromNBTHooks.length; i++)
        {
            if (overrideReadEntityFromNBTHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideReadEntityFromNBTHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void setDead(EntityPlayerMP entityplayermp)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.setDead();
        }
        else
        {
            entityplayermp.localSetDead();
        }
    }

    protected void setDead()
    {
        if (beforeSetDeadHooks != null)
        {
            for (int i = beforeSetDeadHooks.length - 1; i >= 0; i--)
            {
                beforeSetDeadHooks[i].beforeSetDead();
            }
        }

        if (overrideSetDeadHooks != null)
        {
            overrideSetDeadHooks[overrideSetDeadHooks.length - 1].setDead();
        }
        else
        {
            player.localSetDead();
        }

        if (afterSetDeadHooks != null)
        {
            for (int j = 0; j < afterSetDeadHooks.length; j++)
            {
                afterSetDeadHooks[j].afterSetDead();
            }
        }
    }

    protected PlayerBase GetOverwrittenSetDead(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideSetDeadHooks.length; i++)
        {
            if (overrideSetDeadHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideSetDeadHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void setPosition(EntityPlayerMP entityplayermp, double d, double d1, double d2)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.setPosition(d, d1, d2);
        }
        else
        {
            entityplayermp.localSetPosition(d, d1, d2);
        }
    }

    protected void setPosition(double d, double d1, double d2)
    {
        if (beforeSetPositionHooks != null)
        {
            for (int i = beforeSetPositionHooks.length - 1; i >= 0; i--)
            {
                beforeSetPositionHooks[i].beforeSetPosition(d, d1, d2);
            }
        }

        if (overrideSetPositionHooks != null)
        {
            overrideSetPositionHooks[overrideSetPositionHooks.length - 1].setPosition(d, d1, d2);
        }
        else
        {
            player.localSetPosition(d, d1, d2);
        }

        if (afterSetPositionHooks != null)
        {
            for (int j = 0; j < afterSetPositionHooks.length; j++)
            {
                afterSetPositionHooks[j].afterSetPosition(d, d1, d2);
            }
        }
    }

    protected PlayerBase GetOverwrittenSetPosition(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideSetPositionHooks.length; i++)
        {
            if (overrideSetPositionHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideSetPositionHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void updateEntityActionState(EntityPlayerMP entityplayermp)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.updateEntityActionState();
        }
        else
        {
            entityplayermp.localUpdateEntityActionState();
        }
    }

    protected void updateEntityActionState()
    {
        if (beforeUpdateEntityActionStateHooks != null)
        {
            for (int i = beforeUpdateEntityActionStateHooks.length - 1; i >= 0; i--)
            {
                beforeUpdateEntityActionStateHooks[i].beforeUpdateEntityActionState();
            }
        }

        if (overrideUpdateEntityActionStateHooks != null)
        {
            overrideUpdateEntityActionStateHooks[overrideUpdateEntityActionStateHooks.length - 1].updateEntityActionState();
        }
        else
        {
            player.localUpdateEntityActionState();
        }

        if (afterUpdateEntityActionStateHooks != null)
        {
            for (int j = 0; j < afterUpdateEntityActionStateHooks.length; j++)
            {
                afterUpdateEntityActionStateHooks[j].afterUpdateEntityActionState();
            }
        }
    }

    protected PlayerBase GetOverwrittenUpdateEntityActionState(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideUpdateEntityActionStateHooks.length; i++)
        {
            if (overrideUpdateEntityActionStateHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideUpdateEntityActionStateHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    protected static void writeEntityToNBT(EntityPlayerMP entityplayermp, NBTTagCompound nbttagcompound)
    {
        if (entityplayermp.playerAPI != null)
        {
            entityplayermp.playerAPI.writeEntityToNBT(nbttagcompound);
        }
        else
        {
            entityplayermp.localWriteEntityToNBT(nbttagcompound);
        }
    }

    protected void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        if (beforeWriteEntityToNBTHooks != null)
        {
            for (int i = beforeWriteEntityToNBTHooks.length - 1; i >= 0; i--)
            {
                beforeWriteEntityToNBTHooks[i].beforeWriteEntityToNBT(nbttagcompound);
            }
        }

        if (overrideWriteEntityToNBTHooks != null)
        {
            overrideWriteEntityToNBTHooks[overrideWriteEntityToNBTHooks.length - 1].writeEntityToNBT(nbttagcompound);
        }
        else
        {
            player.localWriteEntityToNBT(nbttagcompound);
        }

        if (afterWriteEntityToNBTHooks != null)
        {
            for (int j = 0; j < afterWriteEntityToNBTHooks.length; j++)
            {
                afterWriteEntityToNBTHooks[j].afterWriteEntityToNBT(nbttagcompound);
            }
        }
    }

    protected PlayerBase GetOverwrittenWriteEntityToNBT(PlayerBase playerbase)
    {
        for (int i = 0; i < overrideWriteEntityToNBTHooks.length; i++)
        {
            if (overrideWriteEntityToNBTHooks[i] == playerbase)
            {
                if (i == 0)
                {
                    return null;
                }
                else
                {
                    return overrideWriteEntityToNBTHooks[i - 1];
                }
            }
        }

        return playerbase;
    }

    static
    {
        Class = (new Class[]
                {
                    net.minecraft.src.PlayerAPI.class
                });
        Classes = (new Class[]
                {
                    net.minecraft.src.PlayerAPI.class, java.lang.String.class
                });
        allBaseConstructors = new Hashtable();
        unmodifiableAllIds = Collections.unmodifiableSet(allBaseConstructors.keySet());
    }
}
