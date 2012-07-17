package net.minecraft.src;

public final class PlayerBaseSorting
{
    private String beforeLocalConstructingSuperiors[];
    private String beforeLocalConstructingInferiors[];
    private String afterLocalConstructingSuperiors[];
    private String afterLocalConstructingInferiors[];
    private String beforeAttackEntityFromSuperiors[];
    private String beforeAttackEntityFromInferiors[];
    private String overrideAttackEntityFromSuperiors[];
    private String overrideAttackEntityFromInferiors[];
    private String afterAttackEntityFromSuperiors[];
    private String afterAttackEntityFromInferiors[];
    private String beforeAttackTargetEntityWithCurrentItemSuperiors[];
    private String beforeAttackTargetEntityWithCurrentItemInferiors[];
    private String overrideAttackTargetEntityWithCurrentItemSuperiors[];
    private String overrideAttackTargetEntityWithCurrentItemInferiors[];
    private String afterAttackTargetEntityWithCurrentItemSuperiors[];
    private String afterAttackTargetEntityWithCurrentItemInferiors[];
    private String beforeCanHarvestBlockSuperiors[];
    private String beforeCanHarvestBlockInferiors[];
    private String overrideCanHarvestBlockSuperiors[];
    private String overrideCanHarvestBlockInferiors[];
    private String afterCanHarvestBlockSuperiors[];
    private String afterCanHarvestBlockInferiors[];
    private String beforeCanPlayerEditSuperiors[];
    private String beforeCanPlayerEditInferiors[];
    private String overrideCanPlayerEditSuperiors[];
    private String overrideCanPlayerEditInferiors[];
    private String afterCanPlayerEditSuperiors[];
    private String afterCanPlayerEditInferiors[];
    private String beforeCanTriggerWalkingSuperiors[];
    private String beforeCanTriggerWalkingInferiors[];
    private String overrideCanTriggerWalkingSuperiors[];
    private String overrideCanTriggerWalkingInferiors[];
    private String afterCanTriggerWalkingSuperiors[];
    private String afterCanTriggerWalkingInferiors[];
    private String beforeDamageEntitySuperiors[];
    private String beforeDamageEntityInferiors[];
    private String overrideDamageEntitySuperiors[];
    private String overrideDamageEntityInferiors[];
    private String afterDamageEntitySuperiors[];
    private String afterDamageEntityInferiors[];
    private String beforeDisplayGUIChestSuperiors[];
    private String beforeDisplayGUIChestInferiors[];
    private String overrideDisplayGUIChestSuperiors[];
    private String overrideDisplayGUIChestInferiors[];
    private String afterDisplayGUIChestSuperiors[];
    private String afterDisplayGUIChestInferiors[];
    private String beforeDisplayGUIDispenserSuperiors[];
    private String beforeDisplayGUIDispenserInferiors[];
    private String overrideDisplayGUIDispenserSuperiors[];
    private String overrideDisplayGUIDispenserInferiors[];
    private String afterDisplayGUIDispenserSuperiors[];
    private String afterDisplayGUIDispenserInferiors[];
    private String beforeDisplayGUIFurnaceSuperiors[];
    private String beforeDisplayGUIFurnaceInferiors[];
    private String overrideDisplayGUIFurnaceSuperiors[];
    private String overrideDisplayGUIFurnaceInferiors[];
    private String afterDisplayGUIFurnaceSuperiors[];
    private String afterDisplayGUIFurnaceInferiors[];
    private String beforeDisplayWorkbenchGUISuperiors[];
    private String beforeDisplayWorkbenchGUIInferiors[];
    private String overrideDisplayWorkbenchGUISuperiors[];
    private String overrideDisplayWorkbenchGUIInferiors[];
    private String afterDisplayWorkbenchGUISuperiors[];
    private String afterDisplayWorkbenchGUIInferiors[];
    private String beforeDropOneItemSuperiors[];
    private String beforeDropOneItemInferiors[];
    private String overrideDropOneItemSuperiors[];
    private String overrideDropOneItemInferiors[];
    private String afterDropOneItemSuperiors[];
    private String afterDropOneItemInferiors[];
    private String beforeDropPlayerItemSuperiors[];
    private String beforeDropPlayerItemInferiors[];
    private String overrideDropPlayerItemSuperiors[];
    private String overrideDropPlayerItemInferiors[];
    private String afterDropPlayerItemSuperiors[];
    private String afterDropPlayerItemInferiors[];
    private String beforeFallSuperiors[];
    private String beforeFallInferiors[];
    private String overrideFallSuperiors[];
    private String overrideFallInferiors[];
    private String afterFallSuperiors[];
    private String afterFallInferiors[];
    private String beforeGetCurrentPlayerStrVsBlockSuperiors[];
    private String beforeGetCurrentPlayerStrVsBlockInferiors[];
    private String overrideGetCurrentPlayerStrVsBlockSuperiors[];
    private String overrideGetCurrentPlayerStrVsBlockInferiors[];
    private String afterGetCurrentPlayerStrVsBlockSuperiors[];
    private String afterGetCurrentPlayerStrVsBlockInferiors[];
    private String beforeGetDistanceSqSuperiors[];
    private String beforeGetDistanceSqInferiors[];
    private String overrideGetDistanceSqSuperiors[];
    private String overrideGetDistanceSqInferiors[];
    private String afterGetDistanceSqSuperiors[];
    private String afterGetDistanceSqInferiors[];
    private String beforeGetBrightnessSuperiors[];
    private String beforeGetBrightnessInferiors[];
    private String overrideGetBrightnessSuperiors[];
    private String overrideGetBrightnessInferiors[];
    private String afterGetBrightnessSuperiors[];
    private String afterGetBrightnessInferiors[];
    private String beforeGetEyeHeightSuperiors[];
    private String beforeGetEyeHeightInferiors[];
    private String overrideGetEyeHeightSuperiors[];
    private String overrideGetEyeHeightInferiors[];
    private String afterGetEyeHeightSuperiors[];
    private String afterGetEyeHeightInferiors[];
    private String beforeHealSuperiors[];
    private String beforeHealInferiors[];
    private String overrideHealSuperiors[];
    private String overrideHealInferiors[];
    private String afterHealSuperiors[];
    private String afterHealInferiors[];
    private String beforeInteractSuperiors[];
    private String beforeInteractInferiors[];
    private String overrideInteractSuperiors[];
    private String overrideInteractInferiors[];
    private String afterInteractSuperiors[];
    private String afterInteractInferiors[];
    private String beforeIsEntityInsideOpaqueBlockSuperiors[];
    private String beforeIsEntityInsideOpaqueBlockInferiors[];
    private String overrideIsEntityInsideOpaqueBlockSuperiors[];
    private String overrideIsEntityInsideOpaqueBlockInferiors[];
    private String afterIsEntityInsideOpaqueBlockSuperiors[];
    private String afterIsEntityInsideOpaqueBlockInferiors[];
    private String beforeIsInWaterSuperiors[];
    private String beforeIsInWaterInferiors[];
    private String overrideIsInWaterSuperiors[];
    private String overrideIsInWaterInferiors[];
    private String afterIsInWaterSuperiors[];
    private String afterIsInWaterInferiors[];
    private String beforeIsInsideOfMaterialSuperiors[];
    private String beforeIsInsideOfMaterialInferiors[];
    private String overrideIsInsideOfMaterialSuperiors[];
    private String overrideIsInsideOfMaterialInferiors[];
    private String afterIsInsideOfMaterialSuperiors[];
    private String afterIsInsideOfMaterialInferiors[];
    private String beforeIsOnLadderSuperiors[];
    private String beforeIsOnLadderInferiors[];
    private String overrideIsOnLadderSuperiors[];
    private String overrideIsOnLadderInferiors[];
    private String afterIsOnLadderSuperiors[];
    private String afterIsOnLadderInferiors[];
    private String beforeIsPlayerSleepingSuperiors[];
    private String beforeIsPlayerSleepingInferiors[];
    private String overrideIsPlayerSleepingSuperiors[];
    private String overrideIsPlayerSleepingInferiors[];
    private String afterIsPlayerSleepingSuperiors[];
    private String afterIsPlayerSleepingInferiors[];
    private String beforeJumpSuperiors[];
    private String beforeJumpInferiors[];
    private String overrideJumpSuperiors[];
    private String overrideJumpInferiors[];
    private String afterJumpSuperiors[];
    private String afterJumpInferiors[];
    private String beforeMoveEntitySuperiors[];
    private String beforeMoveEntityInferiors[];
    private String overrideMoveEntitySuperiors[];
    private String overrideMoveEntityInferiors[];
    private String afterMoveEntitySuperiors[];
    private String afterMoveEntityInferiors[];
    private String beforeMoveEntityWithHeadingSuperiors[];
    private String beforeMoveEntityWithHeadingInferiors[];
    private String overrideMoveEntityWithHeadingSuperiors[];
    private String overrideMoveEntityWithHeadingInferiors[];
    private String afterMoveEntityWithHeadingSuperiors[];
    private String afterMoveEntityWithHeadingInferiors[];
    private String beforeMoveFlyingSuperiors[];
    private String beforeMoveFlyingInferiors[];
    private String overrideMoveFlyingSuperiors[];
    private String overrideMoveFlyingInferiors[];
    private String afterMoveFlyingSuperiors[];
    private String afterMoveFlyingInferiors[];
    private String beforeOnDeathSuperiors[];
    private String beforeOnDeathInferiors[];
    private String overrideOnDeathSuperiors[];
    private String overrideOnDeathInferiors[];
    private String afterOnDeathSuperiors[];
    private String afterOnDeathInferiors[];
    private String beforeOnLivingUpdateSuperiors[];
    private String beforeOnLivingUpdateInferiors[];
    private String overrideOnLivingUpdateSuperiors[];
    private String overrideOnLivingUpdateInferiors[];
    private String afterOnLivingUpdateSuperiors[];
    private String afterOnLivingUpdateInferiors[];
    private String beforeOnKillEntitySuperiors[];
    private String beforeOnKillEntityInferiors[];
    private String overrideOnKillEntitySuperiors[];
    private String overrideOnKillEntityInferiors[];
    private String afterOnKillEntitySuperiors[];
    private String afterOnKillEntityInferiors[];
    private String beforeOnUpdateSuperiors[];
    private String beforeOnUpdateInferiors[];
    private String overrideOnUpdateSuperiors[];
    private String overrideOnUpdateInferiors[];
    private String afterOnUpdateSuperiors[];
    private String afterOnUpdateInferiors[];
    private String beforeOnUpdateEntitySuperiors[];
    private String beforeOnUpdateEntityInferiors[];
    private String overrideOnUpdateEntitySuperiors[];
    private String overrideOnUpdateEntityInferiors[];
    private String afterOnUpdateEntitySuperiors[];
    private String afterOnUpdateEntityInferiors[];
    private String beforeReadEntityFromNBTSuperiors[];
    private String beforeReadEntityFromNBTInferiors[];
    private String overrideReadEntityFromNBTSuperiors[];
    private String overrideReadEntityFromNBTInferiors[];
    private String afterReadEntityFromNBTSuperiors[];
    private String afterReadEntityFromNBTInferiors[];
    private String beforeSetDeadSuperiors[];
    private String beforeSetDeadInferiors[];
    private String overrideSetDeadSuperiors[];
    private String overrideSetDeadInferiors[];
    private String afterSetDeadSuperiors[];
    private String afterSetDeadInferiors[];
    private String beforeSetPositionSuperiors[];
    private String beforeSetPositionInferiors[];
    private String overrideSetPositionSuperiors[];
    private String overrideSetPositionInferiors[];
    private String afterSetPositionSuperiors[];
    private String afterSetPositionInferiors[];
    private String beforeUpdateEntityActionStateSuperiors[];
    private String beforeUpdateEntityActionStateInferiors[];
    private String overrideUpdateEntityActionStateSuperiors[];
    private String overrideUpdateEntityActionStateInferiors[];
    private String afterUpdateEntityActionStateSuperiors[];
    private String afterUpdateEntityActionStateInferiors[];
    private String beforeWriteEntityToNBTSuperiors[];
    private String beforeWriteEntityToNBTInferiors[];
    private String overrideWriteEntityToNBTSuperiors[];
    private String overrideWriteEntityToNBTInferiors[];
    private String afterWriteEntityToNBTSuperiors[];
    private String afterWriteEntityToNBTInferiors[];

    public PlayerBaseSorting()
    {
        beforeLocalConstructingSuperiors = null;
        beforeLocalConstructingInferiors = null;
        afterLocalConstructingSuperiors = null;
        afterLocalConstructingInferiors = null;
        beforeAttackEntityFromSuperiors = null;
        beforeAttackEntityFromInferiors = null;
        overrideAttackEntityFromSuperiors = null;
        overrideAttackEntityFromInferiors = null;
        afterAttackEntityFromSuperiors = null;
        afterAttackEntityFromInferiors = null;
        beforeAttackTargetEntityWithCurrentItemSuperiors = null;
        beforeAttackTargetEntityWithCurrentItemInferiors = null;
        overrideAttackTargetEntityWithCurrentItemSuperiors = null;
        overrideAttackTargetEntityWithCurrentItemInferiors = null;
        afterAttackTargetEntityWithCurrentItemSuperiors = null;
        afterAttackTargetEntityWithCurrentItemInferiors = null;
        beforeCanHarvestBlockSuperiors = null;
        beforeCanHarvestBlockInferiors = null;
        overrideCanHarvestBlockSuperiors = null;
        overrideCanHarvestBlockInferiors = null;
        afterCanHarvestBlockSuperiors = null;
        afterCanHarvestBlockInferiors = null;
        beforeCanPlayerEditSuperiors = null;
        beforeCanPlayerEditInferiors = null;
        overrideCanPlayerEditSuperiors = null;
        overrideCanPlayerEditInferiors = null;
        afterCanPlayerEditSuperiors = null;
        afterCanPlayerEditInferiors = null;
        beforeCanTriggerWalkingSuperiors = null;
        beforeCanTriggerWalkingInferiors = null;
        overrideCanTriggerWalkingSuperiors = null;
        overrideCanTriggerWalkingInferiors = null;
        afterCanTriggerWalkingSuperiors = null;
        afterCanTriggerWalkingInferiors = null;
        beforeDamageEntitySuperiors = null;
        beforeDamageEntityInferiors = null;
        overrideDamageEntitySuperiors = null;
        overrideDamageEntityInferiors = null;
        afterDamageEntitySuperiors = null;
        afterDamageEntityInferiors = null;
        beforeDisplayGUIChestSuperiors = null;
        beforeDisplayGUIChestInferiors = null;
        overrideDisplayGUIChestSuperiors = null;
        overrideDisplayGUIChestInferiors = null;
        afterDisplayGUIChestSuperiors = null;
        afterDisplayGUIChestInferiors = null;
        beforeDisplayGUIDispenserSuperiors = null;
        beforeDisplayGUIDispenserInferiors = null;
        overrideDisplayGUIDispenserSuperiors = null;
        overrideDisplayGUIDispenserInferiors = null;
        afterDisplayGUIDispenserSuperiors = null;
        afterDisplayGUIDispenserInferiors = null;
        beforeDisplayGUIFurnaceSuperiors = null;
        beforeDisplayGUIFurnaceInferiors = null;
        overrideDisplayGUIFurnaceSuperiors = null;
        overrideDisplayGUIFurnaceInferiors = null;
        afterDisplayGUIFurnaceSuperiors = null;
        afterDisplayGUIFurnaceInferiors = null;
        beforeDisplayWorkbenchGUISuperiors = null;
        beforeDisplayWorkbenchGUIInferiors = null;
        overrideDisplayWorkbenchGUISuperiors = null;
        overrideDisplayWorkbenchGUIInferiors = null;
        afterDisplayWorkbenchGUISuperiors = null;
        afterDisplayWorkbenchGUIInferiors = null;
        beforeDropOneItemSuperiors = null;
        beforeDropOneItemInferiors = null;
        overrideDropOneItemSuperiors = null;
        overrideDropOneItemInferiors = null;
        afterDropOneItemSuperiors = null;
        afterDropOneItemInferiors = null;
        beforeDropPlayerItemSuperiors = null;
        beforeDropPlayerItemInferiors = null;
        overrideDropPlayerItemSuperiors = null;
        overrideDropPlayerItemInferiors = null;
        afterDropPlayerItemSuperiors = null;
        afterDropPlayerItemInferiors = null;
        beforeFallSuperiors = null;
        beforeFallInferiors = null;
        overrideFallSuperiors = null;
        overrideFallInferiors = null;
        afterFallSuperiors = null;
        afterFallInferiors = null;
        beforeGetCurrentPlayerStrVsBlockSuperiors = null;
        beforeGetCurrentPlayerStrVsBlockInferiors = null;
        overrideGetCurrentPlayerStrVsBlockSuperiors = null;
        overrideGetCurrentPlayerStrVsBlockInferiors = null;
        afterGetCurrentPlayerStrVsBlockSuperiors = null;
        afterGetCurrentPlayerStrVsBlockInferiors = null;
        beforeGetDistanceSqSuperiors = null;
        beforeGetDistanceSqInferiors = null;
        overrideGetDistanceSqSuperiors = null;
        overrideGetDistanceSqInferiors = null;
        afterGetDistanceSqSuperiors = null;
        afterGetDistanceSqInferiors = null;
        beforeGetBrightnessSuperiors = null;
        beforeGetBrightnessInferiors = null;
        overrideGetBrightnessSuperiors = null;
        overrideGetBrightnessInferiors = null;
        afterGetBrightnessSuperiors = null;
        afterGetBrightnessInferiors = null;
        beforeGetEyeHeightSuperiors = null;
        beforeGetEyeHeightInferiors = null;
        overrideGetEyeHeightSuperiors = null;
        overrideGetEyeHeightInferiors = null;
        afterGetEyeHeightSuperiors = null;
        afterGetEyeHeightInferiors = null;
        beforeHealSuperiors = null;
        beforeHealInferiors = null;
        overrideHealSuperiors = null;
        overrideHealInferiors = null;
        afterHealSuperiors = null;
        afterHealInferiors = null;
        beforeInteractSuperiors = null;
        beforeInteractInferiors = null;
        overrideInteractSuperiors = null;
        overrideInteractInferiors = null;
        afterInteractSuperiors = null;
        afterInteractInferiors = null;
        beforeIsEntityInsideOpaqueBlockSuperiors = null;
        beforeIsEntityInsideOpaqueBlockInferiors = null;
        overrideIsEntityInsideOpaqueBlockSuperiors = null;
        overrideIsEntityInsideOpaqueBlockInferiors = null;
        afterIsEntityInsideOpaqueBlockSuperiors = null;
        afterIsEntityInsideOpaqueBlockInferiors = null;
        beforeIsInWaterSuperiors = null;
        beforeIsInWaterInferiors = null;
        overrideIsInWaterSuperiors = null;
        overrideIsInWaterInferiors = null;
        afterIsInWaterSuperiors = null;
        afterIsInWaterInferiors = null;
        beforeIsInsideOfMaterialSuperiors = null;
        beforeIsInsideOfMaterialInferiors = null;
        overrideIsInsideOfMaterialSuperiors = null;
        overrideIsInsideOfMaterialInferiors = null;
        afterIsInsideOfMaterialSuperiors = null;
        afterIsInsideOfMaterialInferiors = null;
        beforeIsOnLadderSuperiors = null;
        beforeIsOnLadderInferiors = null;
        overrideIsOnLadderSuperiors = null;
        overrideIsOnLadderInferiors = null;
        afterIsOnLadderSuperiors = null;
        afterIsOnLadderInferiors = null;
        beforeIsPlayerSleepingSuperiors = null;
        beforeIsPlayerSleepingInferiors = null;
        overrideIsPlayerSleepingSuperiors = null;
        overrideIsPlayerSleepingInferiors = null;
        afterIsPlayerSleepingSuperiors = null;
        afterIsPlayerSleepingInferiors = null;
        beforeJumpSuperiors = null;
        beforeJumpInferiors = null;
        overrideJumpSuperiors = null;
        overrideJumpInferiors = null;
        afterJumpSuperiors = null;
        afterJumpInferiors = null;
        beforeMoveEntitySuperiors = null;
        beforeMoveEntityInferiors = null;
        overrideMoveEntitySuperiors = null;
        overrideMoveEntityInferiors = null;
        afterMoveEntitySuperiors = null;
        afterMoveEntityInferiors = null;
        beforeMoveEntityWithHeadingSuperiors = null;
        beforeMoveEntityWithHeadingInferiors = null;
        overrideMoveEntityWithHeadingSuperiors = null;
        overrideMoveEntityWithHeadingInferiors = null;
        afterMoveEntityWithHeadingSuperiors = null;
        afterMoveEntityWithHeadingInferiors = null;
        beforeMoveFlyingSuperiors = null;
        beforeMoveFlyingInferiors = null;
        overrideMoveFlyingSuperiors = null;
        overrideMoveFlyingInferiors = null;
        afterMoveFlyingSuperiors = null;
        afterMoveFlyingInferiors = null;
        beforeOnDeathSuperiors = null;
        beforeOnDeathInferiors = null;
        overrideOnDeathSuperiors = null;
        overrideOnDeathInferiors = null;
        afterOnDeathSuperiors = null;
        afterOnDeathInferiors = null;
        beforeOnLivingUpdateSuperiors = null;
        beforeOnLivingUpdateInferiors = null;
        overrideOnLivingUpdateSuperiors = null;
        overrideOnLivingUpdateInferiors = null;
        afterOnLivingUpdateSuperiors = null;
        afterOnLivingUpdateInferiors = null;
        beforeOnKillEntitySuperiors = null;
        beforeOnKillEntityInferiors = null;
        overrideOnKillEntitySuperiors = null;
        overrideOnKillEntityInferiors = null;
        afterOnKillEntitySuperiors = null;
        afterOnKillEntityInferiors = null;
        beforeOnUpdateSuperiors = null;
        beforeOnUpdateInferiors = null;
        overrideOnUpdateSuperiors = null;
        overrideOnUpdateInferiors = null;
        afterOnUpdateSuperiors = null;
        afterOnUpdateInferiors = null;
        beforeOnUpdateEntitySuperiors = null;
        beforeOnUpdateEntityInferiors = null;
        overrideOnUpdateEntitySuperiors = null;
        overrideOnUpdateEntityInferiors = null;
        afterOnUpdateEntitySuperiors = null;
        afterOnUpdateEntityInferiors = null;
        beforeReadEntityFromNBTSuperiors = null;
        beforeReadEntityFromNBTInferiors = null;
        overrideReadEntityFromNBTSuperiors = null;
        overrideReadEntityFromNBTInferiors = null;
        afterReadEntityFromNBTSuperiors = null;
        afterReadEntityFromNBTInferiors = null;
        beforeSetDeadSuperiors = null;
        beforeSetDeadInferiors = null;
        overrideSetDeadSuperiors = null;
        overrideSetDeadInferiors = null;
        afterSetDeadSuperiors = null;
        afterSetDeadInferiors = null;
        beforeSetPositionSuperiors = null;
        beforeSetPositionInferiors = null;
        overrideSetPositionSuperiors = null;
        overrideSetPositionInferiors = null;
        afterSetPositionSuperiors = null;
        afterSetPositionInferiors = null;
        beforeUpdateEntityActionStateSuperiors = null;
        beforeUpdateEntityActionStateInferiors = null;
        overrideUpdateEntityActionStateSuperiors = null;
        overrideUpdateEntityActionStateInferiors = null;
        afterUpdateEntityActionStateSuperiors = null;
        afterUpdateEntityActionStateInferiors = null;
        beforeWriteEntityToNBTSuperiors = null;
        beforeWriteEntityToNBTInferiors = null;
        overrideWriteEntityToNBTSuperiors = null;
        overrideWriteEntityToNBTInferiors = null;
        afterWriteEntityToNBTSuperiors = null;
        afterWriteEntityToNBTInferiors = null;
    }

    public String[] getBeforeLocalConstructingSuperiors()
    {
        return beforeLocalConstructingSuperiors;
    }

    public String[] getBeforeLocalConstructingInferiors()
    {
        return beforeLocalConstructingInferiors;
    }

    public String[] getAfterLocalConstructingSuperiors()
    {
        return afterLocalConstructingSuperiors;
    }

    public String[] getAfterLocalConstructingInferiors()
    {
        return afterLocalConstructingInferiors;
    }

    public void setBeforeLocalConstructingSuperiors(String as[])
    {
        beforeLocalConstructingSuperiors = as;
    }

    public void setBeforeLocalConstructingInferiors(String as[])
    {
        beforeLocalConstructingInferiors = as;
    }

    public void setAfterLocalConstructingSuperiors(String as[])
    {
        afterLocalConstructingSuperiors = as;
    }

    public void setAfterLocalConstructingInferiors(String as[])
    {
        afterLocalConstructingInferiors = as;
    }

    public String[] getBeforeAttackEntityFromSuperiors()
    {
        return beforeAttackEntityFromSuperiors;
    }

    public String[] getBeforeAttackEntityFromInferiors()
    {
        return beforeAttackEntityFromInferiors;
    }

    public String[] getOverrideAttackEntityFromSuperiors()
    {
        return overrideAttackEntityFromSuperiors;
    }

    public String[] getOverrideAttackEntityFromInferiors()
    {
        return overrideAttackEntityFromInferiors;
    }

    public String[] getAfterAttackEntityFromSuperiors()
    {
        return afterAttackEntityFromSuperiors;
    }

    public String[] getAfterAttackEntityFromInferiors()
    {
        return afterAttackEntityFromInferiors;
    }

    public void setBeforeAttackEntityFromSuperiors(String as[])
    {
        beforeAttackEntityFromSuperiors = as;
    }

    public void setBeforeAttackEntityFromInferiors(String as[])
    {
        beforeAttackEntityFromInferiors = as;
    }

    public void setOverrideAttackEntityFromSuperiors(String as[])
    {
        overrideAttackEntityFromSuperiors = as;
    }

    public void setOverrideAttackEntityFromInferiors(String as[])
    {
        overrideAttackEntityFromInferiors = as;
    }

    public void setAfterAttackEntityFromSuperiors(String as[])
    {
        afterAttackEntityFromSuperiors = as;
    }

    public void setAfterAttackEntityFromInferiors(String as[])
    {
        afterAttackEntityFromInferiors = as;
    }

    public String[] getBeforeAttackTargetEntityWithCurrentItemSuperiors()
    {
        return beforeAttackTargetEntityWithCurrentItemSuperiors;
    }

    public String[] getBeforeAttackTargetEntityWithCurrentItemInferiors()
    {
        return beforeAttackTargetEntityWithCurrentItemInferiors;
    }

    public String[] getOverrideAttackTargetEntityWithCurrentItemSuperiors()
    {
        return overrideAttackTargetEntityWithCurrentItemSuperiors;
    }

    public String[] getOverrideAttackTargetEntityWithCurrentItemInferiors()
    {
        return overrideAttackTargetEntityWithCurrentItemInferiors;
    }

    public String[] getAfterAttackTargetEntityWithCurrentItemSuperiors()
    {
        return afterAttackTargetEntityWithCurrentItemSuperiors;
    }

    public String[] getAfterAttackTargetEntityWithCurrentItemInferiors()
    {
        return afterAttackTargetEntityWithCurrentItemInferiors;
    }

    public void setBeforeAttackTargetEntityWithCurrentItemSuperiors(String as[])
    {
        beforeAttackTargetEntityWithCurrentItemSuperiors = as;
    }

    public void setBeforeAttackTargetEntityWithCurrentItemInferiors(String as[])
    {
        beforeAttackTargetEntityWithCurrentItemInferiors = as;
    }

    public void setOverrideAttackTargetEntityWithCurrentItemSuperiors(String as[])
    {
        overrideAttackTargetEntityWithCurrentItemSuperiors = as;
    }

    public void setOverrideAttackTargetEntityWithCurrentItemInferiors(String as[])
    {
        overrideAttackTargetEntityWithCurrentItemInferiors = as;
    }

    public void setAfterAttackTargetEntityWithCurrentItemSuperiors(String as[])
    {
        afterAttackTargetEntityWithCurrentItemSuperiors = as;
    }

    public void setAfterAttackTargetEntityWithCurrentItemInferiors(String as[])
    {
        afterAttackTargetEntityWithCurrentItemInferiors = as;
    }

    public String[] getBeforeCanHarvestBlockSuperiors()
    {
        return beforeCanHarvestBlockSuperiors;
    }

    public String[] getBeforeCanHarvestBlockInferiors()
    {
        return beforeCanHarvestBlockInferiors;
    }

    public String[] getOverrideCanHarvestBlockSuperiors()
    {
        return overrideCanHarvestBlockSuperiors;
    }

    public String[] getOverrideCanHarvestBlockInferiors()
    {
        return overrideCanHarvestBlockInferiors;
    }

    public String[] getAfterCanHarvestBlockSuperiors()
    {
        return afterCanHarvestBlockSuperiors;
    }

    public String[] getAfterCanHarvestBlockInferiors()
    {
        return afterCanHarvestBlockInferiors;
    }

    public void setBeforeCanHarvestBlockSuperiors(String as[])
    {
        beforeCanHarvestBlockSuperiors = as;
    }

    public void setBeforeCanHarvestBlockInferiors(String as[])
    {
        beforeCanHarvestBlockInferiors = as;
    }

    public void setOverrideCanHarvestBlockSuperiors(String as[])
    {
        overrideCanHarvestBlockSuperiors = as;
    }

    public void setOverrideCanHarvestBlockInferiors(String as[])
    {
        overrideCanHarvestBlockInferiors = as;
    }

    public void setAfterCanHarvestBlockSuperiors(String as[])
    {
        afterCanHarvestBlockSuperiors = as;
    }

    public void setAfterCanHarvestBlockInferiors(String as[])
    {
        afterCanHarvestBlockInferiors = as;
    }

    public String[] getBeforeCanPlayerEditSuperiors()
    {
        return beforeCanPlayerEditSuperiors;
    }

    public String[] getBeforeCanPlayerEditInferiors()
    {
        return beforeCanPlayerEditInferiors;
    }

    public String[] getOverrideCanPlayerEditSuperiors()
    {
        return overrideCanPlayerEditSuperiors;
    }

    public String[] getOverrideCanPlayerEditInferiors()
    {
        return overrideCanPlayerEditInferiors;
    }

    public String[] getAfterCanPlayerEditSuperiors()
    {
        return afterCanPlayerEditSuperiors;
    }

    public String[] getAfterCanPlayerEditInferiors()
    {
        return afterCanPlayerEditInferiors;
    }

    public void setBeforeCanPlayerEditSuperiors(String as[])
    {
        beforeCanPlayerEditSuperiors = as;
    }

    public void setBeforeCanPlayerEditInferiors(String as[])
    {
        beforeCanPlayerEditInferiors = as;
    }

    public void setOverrideCanPlayerEditSuperiors(String as[])
    {
        overrideCanPlayerEditSuperiors = as;
    }

    public void setOverrideCanPlayerEditInferiors(String as[])
    {
        overrideCanPlayerEditInferiors = as;
    }

    public void setAfterCanPlayerEditSuperiors(String as[])
    {
        afterCanPlayerEditSuperiors = as;
    }

    public void setAfterCanPlayerEditInferiors(String as[])
    {
        afterCanPlayerEditInferiors = as;
    }

    public String[] getBeforeCanTriggerWalkingSuperiors()
    {
        return beforeCanTriggerWalkingSuperiors;
    }

    public String[] getBeforeCanTriggerWalkingInferiors()
    {
        return beforeCanTriggerWalkingInferiors;
    }

    public String[] getOverrideCanTriggerWalkingSuperiors()
    {
        return overrideCanTriggerWalkingSuperiors;
    }

    public String[] getOverrideCanTriggerWalkingInferiors()
    {
        return overrideCanTriggerWalkingInferiors;
    }

    public String[] getAfterCanTriggerWalkingSuperiors()
    {
        return afterCanTriggerWalkingSuperiors;
    }

    public String[] getAfterCanTriggerWalkingInferiors()
    {
        return afterCanTriggerWalkingInferiors;
    }

    public void setBeforeCanTriggerWalkingSuperiors(String as[])
    {
        beforeCanTriggerWalkingSuperiors = as;
    }

    public void setBeforeCanTriggerWalkingInferiors(String as[])
    {
        beforeCanTriggerWalkingInferiors = as;
    }

    public void setOverrideCanTriggerWalkingSuperiors(String as[])
    {
        overrideCanTriggerWalkingSuperiors = as;
    }

    public void setOverrideCanTriggerWalkingInferiors(String as[])
    {
        overrideCanTriggerWalkingInferiors = as;
    }

    public void setAfterCanTriggerWalkingSuperiors(String as[])
    {
        afterCanTriggerWalkingSuperiors = as;
    }

    public void setAfterCanTriggerWalkingInferiors(String as[])
    {
        afterCanTriggerWalkingInferiors = as;
    }

    public String[] getBeforeDamageEntitySuperiors()
    {
        return beforeDamageEntitySuperiors;
    }

    public String[] getBeforeDamageEntityInferiors()
    {
        return beforeDamageEntityInferiors;
    }

    public String[] getOverrideDamageEntitySuperiors()
    {
        return overrideDamageEntitySuperiors;
    }

    public String[] getOverrideDamageEntityInferiors()
    {
        return overrideDamageEntityInferiors;
    }

    public String[] getAfterDamageEntitySuperiors()
    {
        return afterDamageEntitySuperiors;
    }

    public String[] getAfterDamageEntityInferiors()
    {
        return afterDamageEntityInferiors;
    }

    public void setBeforeDamageEntitySuperiors(String as[])
    {
        beforeDamageEntitySuperiors = as;
    }

    public void setBeforeDamageEntityInferiors(String as[])
    {
        beforeDamageEntityInferiors = as;
    }

    public void setOverrideDamageEntitySuperiors(String as[])
    {
        overrideDamageEntitySuperiors = as;
    }

    public void setOverrideDamageEntityInferiors(String as[])
    {
        overrideDamageEntityInferiors = as;
    }

    public void setAfterDamageEntitySuperiors(String as[])
    {
        afterDamageEntitySuperiors = as;
    }

    public void setAfterDamageEntityInferiors(String as[])
    {
        afterDamageEntityInferiors = as;
    }

    public String[] getBeforeDisplayGUIChestSuperiors()
    {
        return beforeDisplayGUIChestSuperiors;
    }

    public String[] getBeforeDisplayGUIChestInferiors()
    {
        return beforeDisplayGUIChestInferiors;
    }

    public String[] getOverrideDisplayGUIChestSuperiors()
    {
        return overrideDisplayGUIChestSuperiors;
    }

    public String[] getOverrideDisplayGUIChestInferiors()
    {
        return overrideDisplayGUIChestInferiors;
    }

    public String[] getAfterDisplayGUIChestSuperiors()
    {
        return afterDisplayGUIChestSuperiors;
    }

    public String[] getAfterDisplayGUIChestInferiors()
    {
        return afterDisplayGUIChestInferiors;
    }

    public void setBeforeDisplayGUIChestSuperiors(String as[])
    {
        beforeDisplayGUIChestSuperiors = as;
    }

    public void setBeforeDisplayGUIChestInferiors(String as[])
    {
        beforeDisplayGUIChestInferiors = as;
    }

    public void setOverrideDisplayGUIChestSuperiors(String as[])
    {
        overrideDisplayGUIChestSuperiors = as;
    }

    public void setOverrideDisplayGUIChestInferiors(String as[])
    {
        overrideDisplayGUIChestInferiors = as;
    }

    public void setAfterDisplayGUIChestSuperiors(String as[])
    {
        afterDisplayGUIChestSuperiors = as;
    }

    public void setAfterDisplayGUIChestInferiors(String as[])
    {
        afterDisplayGUIChestInferiors = as;
    }

    public String[] getBeforeDisplayGUIDispenserSuperiors()
    {
        return beforeDisplayGUIDispenserSuperiors;
    }

    public String[] getBeforeDisplayGUIDispenserInferiors()
    {
        return beforeDisplayGUIDispenserInferiors;
    }

    public String[] getOverrideDisplayGUIDispenserSuperiors()
    {
        return overrideDisplayGUIDispenserSuperiors;
    }

    public String[] getOverrideDisplayGUIDispenserInferiors()
    {
        return overrideDisplayGUIDispenserInferiors;
    }

    public String[] getAfterDisplayGUIDispenserSuperiors()
    {
        return afterDisplayGUIDispenserSuperiors;
    }

    public String[] getAfterDisplayGUIDispenserInferiors()
    {
        return afterDisplayGUIDispenserInferiors;
    }

    public void setBeforeDisplayGUIDispenserSuperiors(String as[])
    {
        beforeDisplayGUIDispenserSuperiors = as;
    }

    public void setBeforeDisplayGUIDispenserInferiors(String as[])
    {
        beforeDisplayGUIDispenserInferiors = as;
    }

    public void setOverrideDisplayGUIDispenserSuperiors(String as[])
    {
        overrideDisplayGUIDispenserSuperiors = as;
    }

    public void setOverrideDisplayGUIDispenserInferiors(String as[])
    {
        overrideDisplayGUIDispenserInferiors = as;
    }

    public void setAfterDisplayGUIDispenserSuperiors(String as[])
    {
        afterDisplayGUIDispenserSuperiors = as;
    }

    public void setAfterDisplayGUIDispenserInferiors(String as[])
    {
        afterDisplayGUIDispenserInferiors = as;
    }

    public String[] getBeforeDisplayGUIFurnaceSuperiors()
    {
        return beforeDisplayGUIFurnaceSuperiors;
    }

    public String[] getBeforeDisplayGUIFurnaceInferiors()
    {
        return beforeDisplayGUIFurnaceInferiors;
    }

    public String[] getOverrideDisplayGUIFurnaceSuperiors()
    {
        return overrideDisplayGUIFurnaceSuperiors;
    }

    public String[] getOverrideDisplayGUIFurnaceInferiors()
    {
        return overrideDisplayGUIFurnaceInferiors;
    }

    public String[] getAfterDisplayGUIFurnaceSuperiors()
    {
        return afterDisplayGUIFurnaceSuperiors;
    }

    public String[] getAfterDisplayGUIFurnaceInferiors()
    {
        return afterDisplayGUIFurnaceInferiors;
    }

    public void setBeforeDisplayGUIFurnaceSuperiors(String as[])
    {
        beforeDisplayGUIFurnaceSuperiors = as;
    }

    public void setBeforeDisplayGUIFurnaceInferiors(String as[])
    {
        beforeDisplayGUIFurnaceInferiors = as;
    }

    public void setOverrideDisplayGUIFurnaceSuperiors(String as[])
    {
        overrideDisplayGUIFurnaceSuperiors = as;
    }

    public void setOverrideDisplayGUIFurnaceInferiors(String as[])
    {
        overrideDisplayGUIFurnaceInferiors = as;
    }

    public void setAfterDisplayGUIFurnaceSuperiors(String as[])
    {
        afterDisplayGUIFurnaceSuperiors = as;
    }

    public void setAfterDisplayGUIFurnaceInferiors(String as[])
    {
        afterDisplayGUIFurnaceInferiors = as;
    }

    public String[] getBeforeDisplayWorkbenchGUISuperiors()
    {
        return beforeDisplayWorkbenchGUISuperiors;
    }

    public String[] getBeforeDisplayWorkbenchGUIInferiors()
    {
        return beforeDisplayWorkbenchGUIInferiors;
    }

    public String[] getOverrideDisplayWorkbenchGUISuperiors()
    {
        return overrideDisplayWorkbenchGUISuperiors;
    }

    public String[] getOverrideDisplayWorkbenchGUIInferiors()
    {
        return overrideDisplayWorkbenchGUIInferiors;
    }

    public String[] getAfterDisplayWorkbenchGUISuperiors()
    {
        return afterDisplayWorkbenchGUISuperiors;
    }

    public String[] getAfterDisplayWorkbenchGUIInferiors()
    {
        return afterDisplayWorkbenchGUIInferiors;
    }

    public void setBeforeDisplayWorkbenchGUISuperiors(String as[])
    {
        beforeDisplayWorkbenchGUISuperiors = as;
    }

    public void setBeforeDisplayWorkbenchGUIInferiors(String as[])
    {
        beforeDisplayWorkbenchGUIInferiors = as;
    }

    public void setOverrideDisplayWorkbenchGUISuperiors(String as[])
    {
        overrideDisplayWorkbenchGUISuperiors = as;
    }

    public void setOverrideDisplayWorkbenchGUIInferiors(String as[])
    {
        overrideDisplayWorkbenchGUIInferiors = as;
    }

    public void setAfterDisplayWorkbenchGUISuperiors(String as[])
    {
        afterDisplayWorkbenchGUISuperiors = as;
    }

    public void setAfterDisplayWorkbenchGUIInferiors(String as[])
    {
        afterDisplayWorkbenchGUIInferiors = as;
    }

    public String[] getBeforeDropOneItemSuperiors()
    {
        return beforeDropOneItemSuperiors;
    }

    public String[] getBeforeDropOneItemInferiors()
    {
        return beforeDropOneItemInferiors;
    }

    public String[] getOverrideDropOneItemSuperiors()
    {
        return overrideDropOneItemSuperiors;
    }

    public String[] getOverrideDropOneItemInferiors()
    {
        return overrideDropOneItemInferiors;
    }

    public String[] getAfterDropOneItemSuperiors()
    {
        return afterDropOneItemSuperiors;
    }

    public String[] getAfterDropOneItemInferiors()
    {
        return afterDropOneItemInferiors;
    }

    public void setBeforeDropOneItemSuperiors(String as[])
    {
        beforeDropOneItemSuperiors = as;
    }

    public void setBeforeDropOneItemInferiors(String as[])
    {
        beforeDropOneItemInferiors = as;
    }

    public void setOverrideDropOneItemSuperiors(String as[])
    {
        overrideDropOneItemSuperiors = as;
    }

    public void setOverrideDropOneItemInferiors(String as[])
    {
        overrideDropOneItemInferiors = as;
    }

    public void setAfterDropOneItemSuperiors(String as[])
    {
        afterDropOneItemSuperiors = as;
    }

    public void setAfterDropOneItemInferiors(String as[])
    {
        afterDropOneItemInferiors = as;
    }

    public String[] getBeforeDropPlayerItemSuperiors()
    {
        return beforeDropPlayerItemSuperiors;
    }

    public String[] getBeforeDropPlayerItemInferiors()
    {
        return beforeDropPlayerItemInferiors;
    }

    public String[] getOverrideDropPlayerItemSuperiors()
    {
        return overrideDropPlayerItemSuperiors;
    }

    public String[] getOverrideDropPlayerItemInferiors()
    {
        return overrideDropPlayerItemInferiors;
    }

    public String[] getAfterDropPlayerItemSuperiors()
    {
        return afterDropPlayerItemSuperiors;
    }

    public String[] getAfterDropPlayerItemInferiors()
    {
        return afterDropPlayerItemInferiors;
    }

    public void setBeforeDropPlayerItemSuperiors(String as[])
    {
        beforeDropPlayerItemSuperiors = as;
    }

    public void setBeforeDropPlayerItemInferiors(String as[])
    {
        beforeDropPlayerItemInferiors = as;
    }

    public void setOverrideDropPlayerItemSuperiors(String as[])
    {
        overrideDropPlayerItemSuperiors = as;
    }

    public void setOverrideDropPlayerItemInferiors(String as[])
    {
        overrideDropPlayerItemInferiors = as;
    }

    public void setAfterDropPlayerItemSuperiors(String as[])
    {
        afterDropPlayerItemSuperiors = as;
    }

    public void setAfterDropPlayerItemInferiors(String as[])
    {
        afterDropPlayerItemInferiors = as;
    }

    public String[] getBeforeFallSuperiors()
    {
        return beforeFallSuperiors;
    }

    public String[] getBeforeFallInferiors()
    {
        return beforeFallInferiors;
    }

    public String[] getOverrideFallSuperiors()
    {
        return overrideFallSuperiors;
    }

    public String[] getOverrideFallInferiors()
    {
        return overrideFallInferiors;
    }

    public String[] getAfterFallSuperiors()
    {
        return afterFallSuperiors;
    }

    public String[] getAfterFallInferiors()
    {
        return afterFallInferiors;
    }

    public void setBeforeFallSuperiors(String as[])
    {
        beforeFallSuperiors = as;
    }

    public void setBeforeFallInferiors(String as[])
    {
        beforeFallInferiors = as;
    }

    public void setOverrideFallSuperiors(String as[])
    {
        overrideFallSuperiors = as;
    }

    public void setOverrideFallInferiors(String as[])
    {
        overrideFallInferiors = as;
    }

    public void setAfterFallSuperiors(String as[])
    {
        afterFallSuperiors = as;
    }

    public void setAfterFallInferiors(String as[])
    {
        afterFallInferiors = as;
    }

    public String[] getBeforeGetCurrentPlayerStrVsBlockSuperiors()
    {
        return beforeGetCurrentPlayerStrVsBlockSuperiors;
    }

    public String[] getBeforeGetCurrentPlayerStrVsBlockInferiors()
    {
        return beforeGetCurrentPlayerStrVsBlockInferiors;
    }

    public String[] getOverrideGetCurrentPlayerStrVsBlockSuperiors()
    {
        return overrideGetCurrentPlayerStrVsBlockSuperiors;
    }

    public String[] getOverrideGetCurrentPlayerStrVsBlockInferiors()
    {
        return overrideGetCurrentPlayerStrVsBlockInferiors;
    }

    public String[] getAfterGetCurrentPlayerStrVsBlockSuperiors()
    {
        return afterGetCurrentPlayerStrVsBlockSuperiors;
    }

    public String[] getAfterGetCurrentPlayerStrVsBlockInferiors()
    {
        return afterGetCurrentPlayerStrVsBlockInferiors;
    }

    public void setBeforeGetCurrentPlayerStrVsBlockSuperiors(String as[])
    {
        beforeGetCurrentPlayerStrVsBlockSuperiors = as;
    }

    public void setBeforeGetCurrentPlayerStrVsBlockInferiors(String as[])
    {
        beforeGetCurrentPlayerStrVsBlockInferiors = as;
    }

    public void setOverrideGetCurrentPlayerStrVsBlockSuperiors(String as[])
    {
        overrideGetCurrentPlayerStrVsBlockSuperiors = as;
    }

    public void setOverrideGetCurrentPlayerStrVsBlockInferiors(String as[])
    {
        overrideGetCurrentPlayerStrVsBlockInferiors = as;
    }

    public void setAfterGetCurrentPlayerStrVsBlockSuperiors(String as[])
    {
        afterGetCurrentPlayerStrVsBlockSuperiors = as;
    }

    public void setAfterGetCurrentPlayerStrVsBlockInferiors(String as[])
    {
        afterGetCurrentPlayerStrVsBlockInferiors = as;
    }

    public String[] getBeforeGetDistanceSqSuperiors()
    {
        return beforeGetDistanceSqSuperiors;
    }

    public String[] getBeforeGetDistanceSqInferiors()
    {
        return beforeGetDistanceSqInferiors;
    }

    public String[] getOverrideGetDistanceSqSuperiors()
    {
        return overrideGetDistanceSqSuperiors;
    }

    public String[] getOverrideGetDistanceSqInferiors()
    {
        return overrideGetDistanceSqInferiors;
    }

    public String[] getAfterGetDistanceSqSuperiors()
    {
        return afterGetDistanceSqSuperiors;
    }

    public String[] getAfterGetDistanceSqInferiors()
    {
        return afterGetDistanceSqInferiors;
    }

    public void setBeforeGetDistanceSqSuperiors(String as[])
    {
        beforeGetDistanceSqSuperiors = as;
    }

    public void setBeforeGetDistanceSqInferiors(String as[])
    {
        beforeGetDistanceSqInferiors = as;
    }

    public void setOverrideGetDistanceSqSuperiors(String as[])
    {
        overrideGetDistanceSqSuperiors = as;
    }

    public void setOverrideGetDistanceSqInferiors(String as[])
    {
        overrideGetDistanceSqInferiors = as;
    }

    public void setAfterGetDistanceSqSuperiors(String as[])
    {
        afterGetDistanceSqSuperiors = as;
    }

    public void setAfterGetDistanceSqInferiors(String as[])
    {
        afterGetDistanceSqInferiors = as;
    }

    public String[] getBeforeGetBrightnessSuperiors()
    {
        return beforeGetBrightnessSuperiors;
    }

    public String[] getBeforeGetBrightnessInferiors()
    {
        return beforeGetBrightnessInferiors;
    }

    public String[] getOverrideGetBrightnessSuperiors()
    {
        return overrideGetBrightnessSuperiors;
    }

    public String[] getOverrideGetBrightnessInferiors()
    {
        return overrideGetBrightnessInferiors;
    }

    public String[] getAfterGetBrightnessSuperiors()
    {
        return afterGetBrightnessSuperiors;
    }

    public String[] getAfterGetBrightnessInferiors()
    {
        return afterGetBrightnessInferiors;
    }

    public void setBeforeGetBrightnessSuperiors(String as[])
    {
        beforeGetBrightnessSuperiors = as;
    }

    public void setBeforeGetBrightnessInferiors(String as[])
    {
        beforeGetBrightnessInferiors = as;
    }

    public void setOverrideGetBrightnessSuperiors(String as[])
    {
        overrideGetBrightnessSuperiors = as;
    }

    public void setOverrideGetBrightnessInferiors(String as[])
    {
        overrideGetBrightnessInferiors = as;
    }

    public void setAfterGetBrightnessSuperiors(String as[])
    {
        afterGetBrightnessSuperiors = as;
    }

    public void setAfterGetBrightnessInferiors(String as[])
    {
        afterGetBrightnessInferiors = as;
    }

    public String[] getBeforeGetEyeHeightSuperiors()
    {
        return beforeGetEyeHeightSuperiors;
    }

    public String[] getBeforeGetEyeHeightInferiors()
    {
        return beforeGetEyeHeightInferiors;
    }

    public String[] getOverrideGetEyeHeightSuperiors()
    {
        return overrideGetEyeHeightSuperiors;
    }

    public String[] getOverrideGetEyeHeightInferiors()
    {
        return overrideGetEyeHeightInferiors;
    }

    public String[] getAfterGetEyeHeightSuperiors()
    {
        return afterGetEyeHeightSuperiors;
    }

    public String[] getAfterGetEyeHeightInferiors()
    {
        return afterGetEyeHeightInferiors;
    }

    public void setBeforeGetEyeHeightSuperiors(String as[])
    {
        beforeGetEyeHeightSuperiors = as;
    }

    public void setBeforeGetEyeHeightInferiors(String as[])
    {
        beforeGetEyeHeightInferiors = as;
    }

    public void setOverrideGetEyeHeightSuperiors(String as[])
    {
        overrideGetEyeHeightSuperiors = as;
    }

    public void setOverrideGetEyeHeightInferiors(String as[])
    {
        overrideGetEyeHeightInferiors = as;
    }

    public void setAfterGetEyeHeightSuperiors(String as[])
    {
        afterGetEyeHeightSuperiors = as;
    }

    public void setAfterGetEyeHeightInferiors(String as[])
    {
        afterGetEyeHeightInferiors = as;
    }

    public String[] getBeforeHealSuperiors()
    {
        return beforeHealSuperiors;
    }

    public String[] getBeforeHealInferiors()
    {
        return beforeHealInferiors;
    }

    public String[] getOverrideHealSuperiors()
    {
        return overrideHealSuperiors;
    }

    public String[] getOverrideHealInferiors()
    {
        return overrideHealInferiors;
    }

    public String[] getAfterHealSuperiors()
    {
        return afterHealSuperiors;
    }

    public String[] getAfterHealInferiors()
    {
        return afterHealInferiors;
    }

    public void setBeforeHealSuperiors(String as[])
    {
        beforeHealSuperiors = as;
    }

    public void setBeforeHealInferiors(String as[])
    {
        beforeHealInferiors = as;
    }

    public void setOverrideHealSuperiors(String as[])
    {
        overrideHealSuperiors = as;
    }

    public void setOverrideHealInferiors(String as[])
    {
        overrideHealInferiors = as;
    }

    public void setAfterHealSuperiors(String as[])
    {
        afterHealSuperiors = as;
    }

    public void setAfterHealInferiors(String as[])
    {
        afterHealInferiors = as;
    }

    public String[] getBeforeInteractSuperiors()
    {
        return beforeInteractSuperiors;
    }

    public String[] getBeforeInteractInferiors()
    {
        return beforeInteractInferiors;
    }

    public String[] getOverrideInteractSuperiors()
    {
        return overrideInteractSuperiors;
    }

    public String[] getOverrideInteractInferiors()
    {
        return overrideInteractInferiors;
    }

    public String[] getAfterInteractSuperiors()
    {
        return afterInteractSuperiors;
    }

    public String[] getAfterInteractInferiors()
    {
        return afterInteractInferiors;
    }

    public void setBeforeInteractSuperiors(String as[])
    {
        beforeInteractSuperiors = as;
    }

    public void setBeforeInteractInferiors(String as[])
    {
        beforeInteractInferiors = as;
    }

    public void setOverrideInteractSuperiors(String as[])
    {
        overrideInteractSuperiors = as;
    }

    public void setOverrideInteractInferiors(String as[])
    {
        overrideInteractInferiors = as;
    }

    public void setAfterInteractSuperiors(String as[])
    {
        afterInteractSuperiors = as;
    }

    public void setAfterInteractInferiors(String as[])
    {
        afterInteractInferiors = as;
    }

    public String[] getBeforeIsEntityInsideOpaqueBlockSuperiors()
    {
        return beforeIsEntityInsideOpaqueBlockSuperiors;
    }

    public String[] getBeforeIsEntityInsideOpaqueBlockInferiors()
    {
        return beforeIsEntityInsideOpaqueBlockInferiors;
    }

    public String[] getOverrideIsEntityInsideOpaqueBlockSuperiors()
    {
        return overrideIsEntityInsideOpaqueBlockSuperiors;
    }

    public String[] getOverrideIsEntityInsideOpaqueBlockInferiors()
    {
        return overrideIsEntityInsideOpaqueBlockInferiors;
    }

    public String[] getAfterIsEntityInsideOpaqueBlockSuperiors()
    {
        return afterIsEntityInsideOpaqueBlockSuperiors;
    }

    public String[] getAfterIsEntityInsideOpaqueBlockInferiors()
    {
        return afterIsEntityInsideOpaqueBlockInferiors;
    }

    public void setBeforeIsEntityInsideOpaqueBlockSuperiors(String as[])
    {
        beforeIsEntityInsideOpaqueBlockSuperiors = as;
    }

    public void setBeforeIsEntityInsideOpaqueBlockInferiors(String as[])
    {
        beforeIsEntityInsideOpaqueBlockInferiors = as;
    }

    public void setOverrideIsEntityInsideOpaqueBlockSuperiors(String as[])
    {
        overrideIsEntityInsideOpaqueBlockSuperiors = as;
    }

    public void setOverrideIsEntityInsideOpaqueBlockInferiors(String as[])
    {
        overrideIsEntityInsideOpaqueBlockInferiors = as;
    }

    public void setAfterIsEntityInsideOpaqueBlockSuperiors(String as[])
    {
        afterIsEntityInsideOpaqueBlockSuperiors = as;
    }

    public void setAfterIsEntityInsideOpaqueBlockInferiors(String as[])
    {
        afterIsEntityInsideOpaqueBlockInferiors = as;
    }

    public String[] getBeforeIsInWaterSuperiors()
    {
        return beforeIsInWaterSuperiors;
    }

    public String[] getBeforeIsInWaterInferiors()
    {
        return beforeIsInWaterInferiors;
    }

    public String[] getOverrideIsInWaterSuperiors()
    {
        return overrideIsInWaterSuperiors;
    }

    public String[] getOverrideIsInWaterInferiors()
    {
        return overrideIsInWaterInferiors;
    }

    public String[] getAfterIsInWaterSuperiors()
    {
        return afterIsInWaterSuperiors;
    }

    public String[] getAfterIsInWaterInferiors()
    {
        return afterIsInWaterInferiors;
    }

    public void setBeforeIsInWaterSuperiors(String as[])
    {
        beforeIsInWaterSuperiors = as;
    }

    public void setBeforeIsInWaterInferiors(String as[])
    {
        beforeIsInWaterInferiors = as;
    }

    public void setOverrideIsInWaterSuperiors(String as[])
    {
        overrideIsInWaterSuperiors = as;
    }

    public void setOverrideIsInWaterInferiors(String as[])
    {
        overrideIsInWaterInferiors = as;
    }

    public void setAfterIsInWaterSuperiors(String as[])
    {
        afterIsInWaterSuperiors = as;
    }

    public void setAfterIsInWaterInferiors(String as[])
    {
        afterIsInWaterInferiors = as;
    }

    public String[] getBeforeIsInsideOfMaterialSuperiors()
    {
        return beforeIsInsideOfMaterialSuperiors;
    }

    public String[] getBeforeIsInsideOfMaterialInferiors()
    {
        return beforeIsInsideOfMaterialInferiors;
    }

    public String[] getOverrideIsInsideOfMaterialSuperiors()
    {
        return overrideIsInsideOfMaterialSuperiors;
    }

    public String[] getOverrideIsInsideOfMaterialInferiors()
    {
        return overrideIsInsideOfMaterialInferiors;
    }

    public String[] getAfterIsInsideOfMaterialSuperiors()
    {
        return afterIsInsideOfMaterialSuperiors;
    }

    public String[] getAfterIsInsideOfMaterialInferiors()
    {
        return afterIsInsideOfMaterialInferiors;
    }

    public void setBeforeIsInsideOfMaterialSuperiors(String as[])
    {
        beforeIsInsideOfMaterialSuperiors = as;
    }

    public void setBeforeIsInsideOfMaterialInferiors(String as[])
    {
        beforeIsInsideOfMaterialInferiors = as;
    }

    public void setOverrideIsInsideOfMaterialSuperiors(String as[])
    {
        overrideIsInsideOfMaterialSuperiors = as;
    }

    public void setOverrideIsInsideOfMaterialInferiors(String as[])
    {
        overrideIsInsideOfMaterialInferiors = as;
    }

    public void setAfterIsInsideOfMaterialSuperiors(String as[])
    {
        afterIsInsideOfMaterialSuperiors = as;
    }

    public void setAfterIsInsideOfMaterialInferiors(String as[])
    {
        afterIsInsideOfMaterialInferiors = as;
    }

    public String[] getBeforeIsOnLadderSuperiors()
    {
        return beforeIsOnLadderSuperiors;
    }

    public String[] getBeforeIsOnLadderInferiors()
    {
        return beforeIsOnLadderInferiors;
    }

    public String[] getOverrideIsOnLadderSuperiors()
    {
        return overrideIsOnLadderSuperiors;
    }

    public String[] getOverrideIsOnLadderInferiors()
    {
        return overrideIsOnLadderInferiors;
    }

    public String[] getAfterIsOnLadderSuperiors()
    {
        return afterIsOnLadderSuperiors;
    }

    public String[] getAfterIsOnLadderInferiors()
    {
        return afterIsOnLadderInferiors;
    }

    public void setBeforeIsOnLadderSuperiors(String as[])
    {
        beforeIsOnLadderSuperiors = as;
    }

    public void setBeforeIsOnLadderInferiors(String as[])
    {
        beforeIsOnLadderInferiors = as;
    }

    public void setOverrideIsOnLadderSuperiors(String as[])
    {
        overrideIsOnLadderSuperiors = as;
    }

    public void setOverrideIsOnLadderInferiors(String as[])
    {
        overrideIsOnLadderInferiors = as;
    }

    public void setAfterIsOnLadderSuperiors(String as[])
    {
        afterIsOnLadderSuperiors = as;
    }

    public void setAfterIsOnLadderInferiors(String as[])
    {
        afterIsOnLadderInferiors = as;
    }

    public String[] getBeforeIsPlayerSleepingSuperiors()
    {
        return beforeIsPlayerSleepingSuperiors;
    }

    public String[] getBeforeIsPlayerSleepingInferiors()
    {
        return beforeIsPlayerSleepingInferiors;
    }

    public String[] getOverrideIsPlayerSleepingSuperiors()
    {
        return overrideIsPlayerSleepingSuperiors;
    }

    public String[] getOverrideIsPlayerSleepingInferiors()
    {
        return overrideIsPlayerSleepingInferiors;
    }

    public String[] getAfterIsPlayerSleepingSuperiors()
    {
        return afterIsPlayerSleepingSuperiors;
    }

    public String[] getAfterIsPlayerSleepingInferiors()
    {
        return afterIsPlayerSleepingInferiors;
    }

    public void setBeforeIsPlayerSleepingSuperiors(String as[])
    {
        beforeIsPlayerSleepingSuperiors = as;
    }

    public void setBeforeIsPlayerSleepingInferiors(String as[])
    {
        beforeIsPlayerSleepingInferiors = as;
    }

    public void setOverrideIsPlayerSleepingSuperiors(String as[])
    {
        overrideIsPlayerSleepingSuperiors = as;
    }

    public void setOverrideIsPlayerSleepingInferiors(String as[])
    {
        overrideIsPlayerSleepingInferiors = as;
    }

    public void setAfterIsPlayerSleepingSuperiors(String as[])
    {
        afterIsPlayerSleepingSuperiors = as;
    }

    public void setAfterIsPlayerSleepingInferiors(String as[])
    {
        afterIsPlayerSleepingInferiors = as;
    }

    public String[] getBeforeJumpSuperiors()
    {
        return beforeJumpSuperiors;
    }

    public String[] getBeforeJumpInferiors()
    {
        return beforeJumpInferiors;
    }

    public String[] getOverrideJumpSuperiors()
    {
        return overrideJumpSuperiors;
    }

    public String[] getOverrideJumpInferiors()
    {
        return overrideJumpInferiors;
    }

    public String[] getAfterJumpSuperiors()
    {
        return afterJumpSuperiors;
    }

    public String[] getAfterJumpInferiors()
    {
        return afterJumpInferiors;
    }

    public void setBeforeJumpSuperiors(String as[])
    {
        beforeJumpSuperiors = as;
    }

    public void setBeforeJumpInferiors(String as[])
    {
        beforeJumpInferiors = as;
    }

    public void setOverrideJumpSuperiors(String as[])
    {
        overrideJumpSuperiors = as;
    }

    public void setOverrideJumpInferiors(String as[])
    {
        overrideJumpInferiors = as;
    }

    public void setAfterJumpSuperiors(String as[])
    {
        afterJumpSuperiors = as;
    }

    public void setAfterJumpInferiors(String as[])
    {
        afterJumpInferiors = as;
    }

    public String[] getBeforeMoveEntitySuperiors()
    {
        return beforeMoveEntitySuperiors;
    }

    public String[] getBeforeMoveEntityInferiors()
    {
        return beforeMoveEntityInferiors;
    }

    public String[] getOverrideMoveEntitySuperiors()
    {
        return overrideMoveEntitySuperiors;
    }

    public String[] getOverrideMoveEntityInferiors()
    {
        return overrideMoveEntityInferiors;
    }

    public String[] getAfterMoveEntitySuperiors()
    {
        return afterMoveEntitySuperiors;
    }

    public String[] getAfterMoveEntityInferiors()
    {
        return afterMoveEntityInferiors;
    }

    public void setBeforeMoveEntitySuperiors(String as[])
    {
        beforeMoveEntitySuperiors = as;
    }

    public void setBeforeMoveEntityInferiors(String as[])
    {
        beforeMoveEntityInferiors = as;
    }

    public void setOverrideMoveEntitySuperiors(String as[])
    {
        overrideMoveEntitySuperiors = as;
    }

    public void setOverrideMoveEntityInferiors(String as[])
    {
        overrideMoveEntityInferiors = as;
    }

    public void setAfterMoveEntitySuperiors(String as[])
    {
        afterMoveEntitySuperiors = as;
    }

    public void setAfterMoveEntityInferiors(String as[])
    {
        afterMoveEntityInferiors = as;
    }

    public String[] getBeforeMoveEntityWithHeadingSuperiors()
    {
        return beforeMoveEntityWithHeadingSuperiors;
    }

    public String[] getBeforeMoveEntityWithHeadingInferiors()
    {
        return beforeMoveEntityWithHeadingInferiors;
    }

    public String[] getOverrideMoveEntityWithHeadingSuperiors()
    {
        return overrideMoveEntityWithHeadingSuperiors;
    }

    public String[] getOverrideMoveEntityWithHeadingInferiors()
    {
        return overrideMoveEntityWithHeadingInferiors;
    }

    public String[] getAfterMoveEntityWithHeadingSuperiors()
    {
        return afterMoveEntityWithHeadingSuperiors;
    }

    public String[] getAfterMoveEntityWithHeadingInferiors()
    {
        return afterMoveEntityWithHeadingInferiors;
    }

    public void setBeforeMoveEntityWithHeadingSuperiors(String as[])
    {
        beforeMoveEntityWithHeadingSuperiors = as;
    }

    public void setBeforeMoveEntityWithHeadingInferiors(String as[])
    {
        beforeMoveEntityWithHeadingInferiors = as;
    }

    public void setOverrideMoveEntityWithHeadingSuperiors(String as[])
    {
        overrideMoveEntityWithHeadingSuperiors = as;
    }

    public void setOverrideMoveEntityWithHeadingInferiors(String as[])
    {
        overrideMoveEntityWithHeadingInferiors = as;
    }

    public void setAfterMoveEntityWithHeadingSuperiors(String as[])
    {
        afterMoveEntityWithHeadingSuperiors = as;
    }

    public void setAfterMoveEntityWithHeadingInferiors(String as[])
    {
        afterMoveEntityWithHeadingInferiors = as;
    }

    public String[] getBeforeMoveFlyingSuperiors()
    {
        return beforeMoveFlyingSuperiors;
    }

    public String[] getBeforeMoveFlyingInferiors()
    {
        return beforeMoveFlyingInferiors;
    }

    public String[] getOverrideMoveFlyingSuperiors()
    {
        return overrideMoveFlyingSuperiors;
    }

    public String[] getOverrideMoveFlyingInferiors()
    {
        return overrideMoveFlyingInferiors;
    }

    public String[] getAfterMoveFlyingSuperiors()
    {
        return afterMoveFlyingSuperiors;
    }

    public String[] getAfterMoveFlyingInferiors()
    {
        return afterMoveFlyingInferiors;
    }

    public void setBeforeMoveFlyingSuperiors(String as[])
    {
        beforeMoveFlyingSuperiors = as;
    }

    public void setBeforeMoveFlyingInferiors(String as[])
    {
        beforeMoveFlyingInferiors = as;
    }

    public void setOverrideMoveFlyingSuperiors(String as[])
    {
        overrideMoveFlyingSuperiors = as;
    }

    public void setOverrideMoveFlyingInferiors(String as[])
    {
        overrideMoveFlyingInferiors = as;
    }

    public void setAfterMoveFlyingSuperiors(String as[])
    {
        afterMoveFlyingSuperiors = as;
    }

    public void setAfterMoveFlyingInferiors(String as[])
    {
        afterMoveFlyingInferiors = as;
    }

    public String[] getBeforeOnDeathSuperiors()
    {
        return beforeOnDeathSuperiors;
    }

    public String[] getBeforeOnDeathInferiors()
    {
        return beforeOnDeathInferiors;
    }

    public String[] getOverrideOnDeathSuperiors()
    {
        return overrideOnDeathSuperiors;
    }

    public String[] getOverrideOnDeathInferiors()
    {
        return overrideOnDeathInferiors;
    }

    public String[] getAfterOnDeathSuperiors()
    {
        return afterOnDeathSuperiors;
    }

    public String[] getAfterOnDeathInferiors()
    {
        return afterOnDeathInferiors;
    }

    public void setBeforeOnDeathSuperiors(String as[])
    {
        beforeOnDeathSuperiors = as;
    }

    public void setBeforeOnDeathInferiors(String as[])
    {
        beforeOnDeathInferiors = as;
    }

    public void setOverrideOnDeathSuperiors(String as[])
    {
        overrideOnDeathSuperiors = as;
    }

    public void setOverrideOnDeathInferiors(String as[])
    {
        overrideOnDeathInferiors = as;
    }

    public void setAfterOnDeathSuperiors(String as[])
    {
        afterOnDeathSuperiors = as;
    }

    public void setAfterOnDeathInferiors(String as[])
    {
        afterOnDeathInferiors = as;
    }

    public String[] getBeforeOnLivingUpdateSuperiors()
    {
        return beforeOnLivingUpdateSuperiors;
    }

    public String[] getBeforeOnLivingUpdateInferiors()
    {
        return beforeOnLivingUpdateInferiors;
    }

    public String[] getOverrideOnLivingUpdateSuperiors()
    {
        return overrideOnLivingUpdateSuperiors;
    }

    public String[] getOverrideOnLivingUpdateInferiors()
    {
        return overrideOnLivingUpdateInferiors;
    }

    public String[] getAfterOnLivingUpdateSuperiors()
    {
        return afterOnLivingUpdateSuperiors;
    }

    public String[] getAfterOnLivingUpdateInferiors()
    {
        return afterOnLivingUpdateInferiors;
    }

    public void setBeforeOnLivingUpdateSuperiors(String as[])
    {
        beforeOnLivingUpdateSuperiors = as;
    }

    public void setBeforeOnLivingUpdateInferiors(String as[])
    {
        beforeOnLivingUpdateInferiors = as;
    }

    public void setOverrideOnLivingUpdateSuperiors(String as[])
    {
        overrideOnLivingUpdateSuperiors = as;
    }

    public void setOverrideOnLivingUpdateInferiors(String as[])
    {
        overrideOnLivingUpdateInferiors = as;
    }

    public void setAfterOnLivingUpdateSuperiors(String as[])
    {
        afterOnLivingUpdateSuperiors = as;
    }

    public void setAfterOnLivingUpdateInferiors(String as[])
    {
        afterOnLivingUpdateInferiors = as;
    }

    public String[] getBeforeOnKillEntitySuperiors()
    {
        return beforeOnKillEntitySuperiors;
    }

    public String[] getBeforeOnKillEntityInferiors()
    {
        return beforeOnKillEntityInferiors;
    }

    public String[] getOverrideOnKillEntitySuperiors()
    {
        return overrideOnKillEntitySuperiors;
    }

    public String[] getOverrideOnKillEntityInferiors()
    {
        return overrideOnKillEntityInferiors;
    }

    public String[] getAfterOnKillEntitySuperiors()
    {
        return afterOnKillEntitySuperiors;
    }

    public String[] getAfterOnKillEntityInferiors()
    {
        return afterOnKillEntityInferiors;
    }

    public void setBeforeOnKillEntitySuperiors(String as[])
    {
        beforeOnKillEntitySuperiors = as;
    }

    public void setBeforeOnKillEntityInferiors(String as[])
    {
        beforeOnKillEntityInferiors = as;
    }

    public void setOverrideOnKillEntitySuperiors(String as[])
    {
        overrideOnKillEntitySuperiors = as;
    }

    public void setOverrideOnKillEntityInferiors(String as[])
    {
        overrideOnKillEntityInferiors = as;
    }

    public void setAfterOnKillEntitySuperiors(String as[])
    {
        afterOnKillEntitySuperiors = as;
    }

    public void setAfterOnKillEntityInferiors(String as[])
    {
        afterOnKillEntityInferiors = as;
    }

    public String[] getBeforeOnUpdateSuperiors()
    {
        return beforeOnUpdateSuperiors;
    }

    public String[] getBeforeOnUpdateInferiors()
    {
        return beforeOnUpdateInferiors;
    }

    public String[] getOverrideOnUpdateSuperiors()
    {
        return overrideOnUpdateSuperiors;
    }

    public String[] getOverrideOnUpdateInferiors()
    {
        return overrideOnUpdateInferiors;
    }

    public String[] getAfterOnUpdateSuperiors()
    {
        return afterOnUpdateSuperiors;
    }

    public String[] getAfterOnUpdateInferiors()
    {
        return afterOnUpdateInferiors;
    }

    public void setBeforeOnUpdateSuperiors(String as[])
    {
        beforeOnUpdateSuperiors = as;
    }

    public void setBeforeOnUpdateInferiors(String as[])
    {
        beforeOnUpdateInferiors = as;
    }

    public void setOverrideOnUpdateSuperiors(String as[])
    {
        overrideOnUpdateSuperiors = as;
    }

    public void setOverrideOnUpdateInferiors(String as[])
    {
        overrideOnUpdateInferiors = as;
    }

    public void setAfterOnUpdateSuperiors(String as[])
    {
        afterOnUpdateSuperiors = as;
    }

    public void setAfterOnUpdateInferiors(String as[])
    {
        afterOnUpdateInferiors = as;
    }

    public String[] getBeforeOnUpdateEntitySuperiors()
    {
        return beforeOnUpdateEntitySuperiors;
    }

    public String[] getBeforeOnUpdateEntityInferiors()
    {
        return beforeOnUpdateEntityInferiors;
    }

    public String[] getOverrideOnUpdateEntitySuperiors()
    {
        return overrideOnUpdateEntitySuperiors;
    }

    public String[] getOverrideOnUpdateEntityInferiors()
    {
        return overrideOnUpdateEntityInferiors;
    }

    public String[] getAfterOnUpdateEntitySuperiors()
    {
        return afterOnUpdateEntitySuperiors;
    }

    public String[] getAfterOnUpdateEntityInferiors()
    {
        return afterOnUpdateEntityInferiors;
    }

    public void setBeforeOnUpdateEntitySuperiors(String as[])
    {
        beforeOnUpdateEntitySuperiors = as;
    }

    public void setBeforeOnUpdateEntityInferiors(String as[])
    {
        beforeOnUpdateEntityInferiors = as;
    }

    public void setOverrideOnUpdateEntitySuperiors(String as[])
    {
        overrideOnUpdateEntitySuperiors = as;
    }

    public void setOverrideOnUpdateEntityInferiors(String as[])
    {
        overrideOnUpdateEntityInferiors = as;
    }

    public void setAfterOnUpdateEntitySuperiors(String as[])
    {
        afterOnUpdateEntitySuperiors = as;
    }

    public void setAfterOnUpdateEntityInferiors(String as[])
    {
        afterOnUpdateEntityInferiors = as;
    }

    public String[] getBeforeReadEntityFromNBTSuperiors()
    {
        return beforeReadEntityFromNBTSuperiors;
    }

    public String[] getBeforeReadEntityFromNBTInferiors()
    {
        return beforeReadEntityFromNBTInferiors;
    }

    public String[] getOverrideReadEntityFromNBTSuperiors()
    {
        return overrideReadEntityFromNBTSuperiors;
    }

    public String[] getOverrideReadEntityFromNBTInferiors()
    {
        return overrideReadEntityFromNBTInferiors;
    }

    public String[] getAfterReadEntityFromNBTSuperiors()
    {
        return afterReadEntityFromNBTSuperiors;
    }

    public String[] getAfterReadEntityFromNBTInferiors()
    {
        return afterReadEntityFromNBTInferiors;
    }

    public void setBeforeReadEntityFromNBTSuperiors(String as[])
    {
        beforeReadEntityFromNBTSuperiors = as;
    }

    public void setBeforeReadEntityFromNBTInferiors(String as[])
    {
        beforeReadEntityFromNBTInferiors = as;
    }

    public void setOverrideReadEntityFromNBTSuperiors(String as[])
    {
        overrideReadEntityFromNBTSuperiors = as;
    }

    public void setOverrideReadEntityFromNBTInferiors(String as[])
    {
        overrideReadEntityFromNBTInferiors = as;
    }

    public void setAfterReadEntityFromNBTSuperiors(String as[])
    {
        afterReadEntityFromNBTSuperiors = as;
    }

    public void setAfterReadEntityFromNBTInferiors(String as[])
    {
        afterReadEntityFromNBTInferiors = as;
    }

    public String[] getBeforeSetDeadSuperiors()
    {
        return beforeSetDeadSuperiors;
    }

    public String[] getBeforeSetDeadInferiors()
    {
        return beforeSetDeadInferiors;
    }

    public String[] getOverrideSetDeadSuperiors()
    {
        return overrideSetDeadSuperiors;
    }

    public String[] getOverrideSetDeadInferiors()
    {
        return overrideSetDeadInferiors;
    }

    public String[] getAfterSetDeadSuperiors()
    {
        return afterSetDeadSuperiors;
    }

    public String[] getAfterSetDeadInferiors()
    {
        return afterSetDeadInferiors;
    }

    public void setBeforeSetDeadSuperiors(String as[])
    {
        beforeSetDeadSuperiors = as;
    }

    public void setBeforeSetDeadInferiors(String as[])
    {
        beforeSetDeadInferiors = as;
    }

    public void setOverrideSetDeadSuperiors(String as[])
    {
        overrideSetDeadSuperiors = as;
    }

    public void setOverrideSetDeadInferiors(String as[])
    {
        overrideSetDeadInferiors = as;
    }

    public void setAfterSetDeadSuperiors(String as[])
    {
        afterSetDeadSuperiors = as;
    }

    public void setAfterSetDeadInferiors(String as[])
    {
        afterSetDeadInferiors = as;
    }

    public String[] getBeforeSetPositionSuperiors()
    {
        return beforeSetPositionSuperiors;
    }

    public String[] getBeforeSetPositionInferiors()
    {
        return beforeSetPositionInferiors;
    }

    public String[] getOverrideSetPositionSuperiors()
    {
        return overrideSetPositionSuperiors;
    }

    public String[] getOverrideSetPositionInferiors()
    {
        return overrideSetPositionInferiors;
    }

    public String[] getAfterSetPositionSuperiors()
    {
        return afterSetPositionSuperiors;
    }

    public String[] getAfterSetPositionInferiors()
    {
        return afterSetPositionInferiors;
    }

    public void setBeforeSetPositionSuperiors(String as[])
    {
        beforeSetPositionSuperiors = as;
    }

    public void setBeforeSetPositionInferiors(String as[])
    {
        beforeSetPositionInferiors = as;
    }

    public void setOverrideSetPositionSuperiors(String as[])
    {
        overrideSetPositionSuperiors = as;
    }

    public void setOverrideSetPositionInferiors(String as[])
    {
        overrideSetPositionInferiors = as;
    }

    public void setAfterSetPositionSuperiors(String as[])
    {
        afterSetPositionSuperiors = as;
    }

    public void setAfterSetPositionInferiors(String as[])
    {
        afterSetPositionInferiors = as;
    }

    public String[] getBeforeUpdateEntityActionStateSuperiors()
    {
        return beforeUpdateEntityActionStateSuperiors;
    }

    public String[] getBeforeUpdateEntityActionStateInferiors()
    {
        return beforeUpdateEntityActionStateInferiors;
    }

    public String[] getOverrideUpdateEntityActionStateSuperiors()
    {
        return overrideUpdateEntityActionStateSuperiors;
    }

    public String[] getOverrideUpdateEntityActionStateInferiors()
    {
        return overrideUpdateEntityActionStateInferiors;
    }

    public String[] getAfterUpdateEntityActionStateSuperiors()
    {
        return afterUpdateEntityActionStateSuperiors;
    }

    public String[] getAfterUpdateEntityActionStateInferiors()
    {
        return afterUpdateEntityActionStateInferiors;
    }

    public void setBeforeUpdateEntityActionStateSuperiors(String as[])
    {
        beforeUpdateEntityActionStateSuperiors = as;
    }

    public void setBeforeUpdateEntityActionStateInferiors(String as[])
    {
        beforeUpdateEntityActionStateInferiors = as;
    }

    public void setOverrideUpdateEntityActionStateSuperiors(String as[])
    {
        overrideUpdateEntityActionStateSuperiors = as;
    }

    public void setOverrideUpdateEntityActionStateInferiors(String as[])
    {
        overrideUpdateEntityActionStateInferiors = as;
    }

    public void setAfterUpdateEntityActionStateSuperiors(String as[])
    {
        afterUpdateEntityActionStateSuperiors = as;
    }

    public void setAfterUpdateEntityActionStateInferiors(String as[])
    {
        afterUpdateEntityActionStateInferiors = as;
    }

    public String[] getBeforeWriteEntityToNBTSuperiors()
    {
        return beforeWriteEntityToNBTSuperiors;
    }

    public String[] getBeforeWriteEntityToNBTInferiors()
    {
        return beforeWriteEntityToNBTInferiors;
    }

    public String[] getOverrideWriteEntityToNBTSuperiors()
    {
        return overrideWriteEntityToNBTSuperiors;
    }

    public String[] getOverrideWriteEntityToNBTInferiors()
    {
        return overrideWriteEntityToNBTInferiors;
    }

    public String[] getAfterWriteEntityToNBTSuperiors()
    {
        return afterWriteEntityToNBTSuperiors;
    }

    public String[] getAfterWriteEntityToNBTInferiors()
    {
        return afterWriteEntityToNBTInferiors;
    }

    public void setBeforeWriteEntityToNBTSuperiors(String as[])
    {
        beforeWriteEntityToNBTSuperiors = as;
    }

    public void setBeforeWriteEntityToNBTInferiors(String as[])
    {
        beforeWriteEntityToNBTInferiors = as;
    }

    public void setOverrideWriteEntityToNBTSuperiors(String as[])
    {
        overrideWriteEntityToNBTSuperiors = as;
    }

    public void setOverrideWriteEntityToNBTInferiors(String as[])
    {
        overrideWriteEntityToNBTInferiors = as;
    }

    public void setAfterWriteEntityToNBTSuperiors(String as[])
    {
        afterWriteEntityToNBTSuperiors = as;
    }

    public void setAfterWriteEntityToNBTInferiors(String as[])
    {
        afterWriteEntityToNBTInferiors = as;
    }
}
