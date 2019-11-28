package com.azure.azurecompat;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

import com.azure.azurecompat.config.Config;
import com.azure.azurecompat.util.AlikeToolsCompact;
import com.azure.azurecompat.util.AquacultureCompat;
import com.azure.azurecompat.util.BetterAnimalsPlusCompat;
import com.azure.azurecompat.util.BluePowerCompat;
import com.azure.azurecompat.util.BountifulBaublesCompact;
import com.azure.azurecompat.util.CloudBootsCompat;
import com.azure.azurecompat.util.CombatCompat;
import com.azure.azurecompat.util.CompactedCompat;
import com.azure.azurecompat.util.CraftHuntCompat;
import com.azure.azurecompat.util.CyclicCompat;
import com.azure.azurecompat.util.DruidcraftCompact;
import com.azure.azurecompat.util.EasySteelCompat;
import com.azure.azurecompat.util.EndergeticCompat;
import com.azure.azurecompat.util.EnigmaticLegacyCompat;
import com.azure.azurecompat.util.EssentialFeaturesCompat;
import com.azure.azurecompat.util.ExplorercraftCompat;
import com.azure.azurecompat.util.ExtraBowsCompat;
import com.azure.azurecompat.util.FarlandersCompat;
import com.azure.azurecompat.util.ForbiddenandArcanusCompat;
import com.azure.azurecompat.util.FunItemsModCompat;
import com.azure.azurecompat.util.GemsPlusPlusCompat;
import com.azure.azurecompat.util.GobberCompat;
import com.azure.azurecompat.util.GoodNightSleepCompat;
import com.azure.azurecompat.util.IlikewoodCompact;
import com.azure.azurecompat.util.LongFallBootsCompat;
import com.azure.azurecompat.util.LuckyOresCompat;
import com.azure.azurecompat.util.MidnightCompat;
import com.azure.azurecompat.util.MinecoloniesCompat;
import com.azure.azurecompat.util.MoreProgressionCompat;
import com.azure.azurecompat.util.MubbleCompat;
import com.azure.azurecompat.util.MutantBeastsCompat;
import com.azure.azurecompat.util.MysticalWorldCompat;
import com.azure.azurecompat.util.NethercraftCompat;
import com.azure.azurecompat.util.OresAboveDiamondsCompat;
import com.azure.azurecompat.util.PattysMoreArmorCompat;
import com.azure.azurecompat.util.PattysMoreStuffCompat;
import com.azure.azurecompat.util.PattysMoreToolsCompat;
import com.azure.azurecompat.util.PlantTech2Compat;
import com.azure.azurecompat.util.PolyOresCompat;
import com.azure.azurecompat.util.QuarkCompat;
import com.azure.azurecompat.util.RaysDonglesCompat;
import com.azure.azurecompat.util.RediscoveredCompat;
import com.azure.azurecompat.util.RestrictionsCompat;
import com.azure.azurecompat.util.SimpleDiveGearCompat;
import com.azure.azurecompat.util.SolarGenerationCompat;
import com.azure.azurecompat.util.SpartanShieldsCompat;
import com.azure.azurecompat.util.SwitchBowCompat;
import com.azure.azurecompat.util.TetraCompat;
import com.azure.azurecompat.util.TheOneProbeCompat;
import com.azure.azurecompat.util.TofuCraftCompat;
import com.azure.azurecompat.util.UnderwaterBiomeCompat;
import com.azure.azurecompat.util.UnstabletoolsCompat;
import com.azure.azurecompat.util.UselessSwordCompat;
import com.azure.azurecompat.util.VanillaCompat;
import com.azure.azurecompat.util.WitherSkeletonTweaksCompact;
import com.azure.azurecompat.util.WyrmroostCompat;
import com.azure.azurecompat.util.XercaCompact;
import com.azure.azurecompat.util.YoyosCompat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("azurecompat")
public class AzureCompat {

	public static AzureCompat instance;
	public static final String MODID = "azurecompat";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public AzureCompat() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		instance = this;
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.spec,
				"mine-and-slash-autocompat-config.toml");
		Config.loadConfig(Config.spec,
				FMLPaths.CONFIGDIR.get().resolve("mine-and-slash-autocompat-config.toml").toString());
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void processIMC(final InterModProcessEvent event) {
		if (Config.INSTANCE.USE_COMPATIBILITY_ON_VANILLA_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new VanillaCompat());
		}
		if (ModList.get().isLoaded("wyrmroost") && Config.INSTANCE.USE_COMPATIBILITY_ON_WYRMROOST_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new WyrmroostCompat());
		}
		if (ModList.get().isLoaded("enigmaticlegacy")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_ENIGMATICLEGACY_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new EnigmaticLegacyCompat());
		}
		if (ModList.get().isLoaded("forbidden_arcanus")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_FORBIDDENARCANUS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new ForbiddenandArcanusCompat());
		}
		if (ModList.get().isLoaded("bluepower") && Config.INSTANCE.USE_COMPATIBILITY_ON_BLUEPOWER_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new BluePowerCompat());
		}
		if (ModList.get().isLoaded("nethercraft") && Config.INSTANCE.USE_COMPATIBILITY_ON_NETHERCRAFT_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new NethercraftCompat());
		}
		if (ModList.get().isLoaded("minecolonies") && Config.INSTANCE.USE_COMPATIBILITY_ON_MINECOLONIES_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new MinecoloniesCompat());
		}
		if (ModList.get().isLoaded("planttech2") && Config.INSTANCE.USE_COMPATIBILITY_ON_PLANTTECH2_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new PlantTech2Compat());
		}
		if (ModList.get().isLoaded("theoneprobe") && Config.INSTANCE.USE_COMPATIBILITY_ON_THEONEPROBE_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new TheOneProbeCompat());
		}
		if (ModList.get().isLoaded("restrictions") && Config.INSTANCE.USE_COMPATIBILITY_ON_RESTRICTIONS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new RestrictionsCompat());
		}
		if (ModList.get().isLoaded("simpledivegear")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_SIMPLEDIVEGEAR_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new SimpleDiveGearCompat());
		}
		if (ModList.get().isLoaded("longfallboots") && Config.INSTANCE.USE_COMPATIBILITY_ON_LONGFALLBOOTS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new LongFallBootsCompat());
		}
		if (ModList.get().isLoaded("solargeneration")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_SOLARGENERATION_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new SolarGenerationCompat());
		}
		if (ModList.get().isLoaded("betteranimalsplus")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_BETTERANIMALSPLUS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new BetterAnimalsPlusCompat());
		}
		if (ModList.get().isLoaded("compacted") && Config.INSTANCE.USE_COMPATIBILITY_ON_COMPACTED_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new CompactedCompat());
		}
		if (ModList.get().isLoaded("gemsplusplus") && Config.INSTANCE.USE_COMPATIBILITY_ON_GEMSPLUSPLUS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new GemsPlusPlusCompat());
		}
		if (ModList.get().isLoaded("oresabovediamonds")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_ORESABOVEDIAMONDS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new OresAboveDiamondsCompat());
		}
		if (ModList.get().isLoaded("combat") && Config.INSTANCE.USE_COMPATIBILITY_ON_COMBAT_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new CombatCompat());
		}
		if (ModList.get().isLoaded("mysticalworld") && Config.INSTANCE.USE_COMPATIBILITY_ON_MYSTICALWORLD_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new MysticalWorldCompat());
		}
		if (ModList.get().isLoaded("quark") && Config.INSTANCE.USE_COMPATIBILITY_ON_QUARK_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new QuarkCompat());
		}
		if (ModList.get().isLoaded("gobber2") && Config.INSTANCE.USE_COMPATIBILITY_ON_GOBBER_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new GobberCompat());
		}
		if (ModList.get().isLoaded("tofucraft") && Config.INSTANCE.USE_COMPATIBILITY_ON_TOFUCRAFT_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new TofuCraftCompat());
		}
		if (ModList.get().isLoaded("polyores") && Config.INSTANCE.USE_COMPATIBILITY_ON_POLYORES_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new PolyOresCompat());
		}
		if (ModList.get().isLoaded("aquaculture") && Config.INSTANCE.USE_COMPATIBILITY_ON_AQUACULTURE_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new AquacultureCompat());
		}
		if (ModList.get().isLoaded("spartanshields")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_SPARTANSHIELDS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new SpartanShieldsCompat());
		}
		if (ModList.get().isLoaded("goodnightsleep")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_GOODNIGHTSLEEP_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new GoodNightSleepCompat());
		}
		if (ModList.get().isLoaded("cloudboots") && Config.INSTANCE.USE_COMPATIBILITY_ON_CLOUDBOOTS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new CloudBootsCompat());
		}
		if (ModList.get().isLoaded("funmod") && Config.INSTANCE.USE_COMPATIBILITY_ON_FUNITEMSMOD_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new FunItemsModCompat());
		}
		if (ModList.get().isLoaded("tetra") && Config.INSTANCE.USE_COMPATIBILITY_ON_TETRA_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new TetraCompat());
		}
		if (ModList.get().isLoaded("explorercraft") && Config.INSTANCE.USE_COMPATIBILITY_ON_EXPLORERCRAFT_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new ExplorercraftCompat());
		}
		if (ModList.get().isLoaded("craftandhunt") && Config.INSTANCE.USE_COMPATIBILITY_ON_CRAFTHUNT_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new CraftHuntCompat());
		}
		if (ModList.get().isLoaded("aliketools") && Config.INSTANCE.USE_COMPATIBILITY_ON_ALIKETOOLS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new AlikeToolsCompact());
		}
		if (ModList.get().isLoaded("ilikewood") && Config.INSTANCE.USE_COMPATIBILITY_ON_ILIKEWOOD_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new IlikewoodCompact());
		}
		if (ModList.get().isLoaded("bountifulbaubles")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_BOUNTIFULBAUBLES_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new BountifulBaublesCompact());
		}
		if (ModList.get().isLoaded("druidcraft") && Config.INSTANCE.USE_COMPATIBILITY_ON_DRUIDCRAFT_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new DruidcraftCompact());
		}
		if (ModList.get().isLoaded("wstweaks")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_WITHERSKELETONTWEAKS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new WitherSkeletonTweaksCompact());
		}
		if (ModList.get().isLoaded("xercamod") && Config.INSTANCE.USE_COMPATIBILITY_ON_XERCA_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new XercaCompact());
		}
		if (ModList.get().isLoaded("switchbow") && Config.INSTANCE.USE_COMPATIBILITY_ON_SWITCHBOW_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new SwitchBowCompat());
		}
		if (ModList.get().isLoaded("extrabows") && Config.INSTANCE.USE_COMPATIBILITY_ON_EXTRABOWS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new ExtraBowsCompat());
		}
		if (ModList.get().isLoaded("cyclic") && Config.INSTANCE.USE_COMPATIBILITY_ON_CYCLIC_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new CyclicCompat());
		}
		if (ModList.get().isLoaded("essentialfeatures")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_ESSENTIALFEATURES_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new EssentialFeaturesCompat());
		}
		if (ModList.get().isLoaded("unstabletools") && Config.INSTANCE.USE_COMPATIBILITY_ON_UNSTABLETOOLS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new UnstabletoolsCompat());
		}
		if (ModList.get().isLoaded("midnight") && Config.INSTANCE.USE_COMPATIBILITY_ON_MIDNIGHT_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new MidnightCompat());
		}
		if (ModList.get().isLoaded("farlanders") && Config.INSTANCE.USE_COMPATIBILITY_ON_FARLANDERS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new FarlandersCompat());
		}
		if (ModList.get().isLoaded("mubble") && Config.INSTANCE.USE_COMPATIBILITY_ON_MUBBLE_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new MubbleCompat());
		}
		if (ModList.get().isLoaded("luckyores") && Config.INSTANCE.USE_COMPATIBILITY_ON_LUCKYORES_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new LuckyOresCompat());
		}
		if (ModList.get().isLoaded("rediscovered") && Config.INSTANCE.USE_COMPATIBILITY_ON_REDISCOVERED_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new RediscoveredCompat());
		}
		if (ModList.get().isLoaded("easy_steel") && Config.INSTANCE.USE_COMPATIBILITY_ON_EASYSTEEL_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new EasySteelCompat());
		}
		if (ModList.get().isLoaded("useless_sword") && Config.INSTANCE.USE_COMPATIBILITY_ON_USELESSSWORD_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new UselessSwordCompat());
		}
		if (ModList.get().isLoaded("yoyos") && Config.INSTANCE.USE_COMPATIBILITY_ON_YOYOS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new YoyosCompat());
		}
		if (ModList.get().isLoaded("underwaterbiome")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_UNDERWATERBIOME_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new UnderwaterBiomeCompat());
		}
		if (ModList.get().isLoaded("pattysmoretools")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_PATTYSMORETOOLS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new PattysMoreToolsCompat());
		}
		if (ModList.get().isLoaded("pattysmorestuff")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_PATTYSMORESTUFF_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new PattysMoreStuffCompat());
		}
		if (ModList.get().isLoaded("pattysmorearmor")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_PATTYSMOREARMOR_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new PattysMoreArmorCompat());
		}
		if (ModList.get().isLoaded("slurpiesdongles") && Config.INSTANCE.USE_COMPATIBILITY_ON_RAYSDONGLES_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new RaysDonglesCompat());
		}
		if (ModList.get().isLoaded("moreprogression")
				&& Config.INSTANCE.USE_COMPATIBILITY_ON_MOREPROGRESSION_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new MoreProgressionCompat());
		}
		if (ModList.get().isLoaded("mutantbeasts") && Config.INSTANCE.USE_COMPATIBILITY_ON_MUTANTBEASTS_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new MutantBeastsCompat());
		}
		if (ModList.get().isLoaded("endergetic") && Config.INSTANCE.USE_COMPATIBILITY_ON_ENDERGETIC_ITEMS.get()) {
			MinecraftForge.EVENT_BUS.register(new EndergeticCompat());
		}
	}
}
