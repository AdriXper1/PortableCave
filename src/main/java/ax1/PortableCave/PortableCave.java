package ax1.PortableCave;

import ax1.PortableCave.block.ModBlock;
import ax1.PortableCave.block.blockEntity.ModBlockEntity;
import ax1.PortableCave.block.blockEntity.custom.*;
import ax1.PortableCave.genGrabber.GenGrabber;
import ax1.PortableCave.item.ModItem;
import ax1.PortableCave.tab.ModTab;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(PortableCave.MODID)
public class PortableCave {
    public static final String MODID = "portablecave";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PortableCave(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModBlock.register(modEventBus);
        ModBlockEntity.register(modEventBus);
        ModItem.register(modEventBus);
        ModTab.register(modEventBus);

        modEventBus.addListener(this::registerCapabilities);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("IT WORK!!!");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
        LOGGER.info("starting block grabber");
        GenGrabber.onServerStarting(event);
    }

    private void registerCapabilities(RegisterCapabilitiesEvent event){
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntity.BLOCK_EXTRACTOR_BE.get(), BlockExtractorBlockEntityBasic::getEnergyStorage);
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntity.ORE_EXTRACTOR_BE.get(), OreExtractorBlockEntityBasic::getEnergyStorage);
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntity.BLOCK_GENERATOR_BE.get(), BlockGeneratorBlockEntityBasic::getEnergyStorage);
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntity.ORE_GENERATOR_BE.get(), OreGeneratorBlockEntityBasic::getEnergyStorage);
    }
}