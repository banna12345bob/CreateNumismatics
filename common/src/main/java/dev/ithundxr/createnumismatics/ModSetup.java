package dev.ithundxr.createnumismatics;

import com.simibubi.create.content.equipment.goggles.GogglesItem;
import dev.ithundxr.createnumismatics.multiloader.Env;
import dev.ithundxr.createnumismatics.registry.*;
import dev.ithundxr.createnumismatics.util.ClientUtils;
import org.apache.commons.lang3.mutable.MutableObject;

public class ModSetup {
    public static void register() {
        NumismaticsItems.init();
        NumismaticsBlockEntities.register();
        NumismaticsBlocks.init();
        NumismaticsMenuTypes.register();
        NumismaticsTags.register();

        GogglesItem.addIsWearingPredicate((player) -> {
            if (!new Exception().getStackTrace()[2].getClassName().equals("com.simibubi.create.content.equipment.goggles.GoggleOverlayRenderer"))
                return false;
            MutableObject<Boolean> isLookingAtForced = new MutableObject<>(false);
            Env.CLIENT.runIfCurrent(() -> () -> isLookingAtForced.setValue(ClientUtils.isLookingAtForcedGoggleOverlay()));
            return isLookingAtForced.getValue();
        });
    }
}