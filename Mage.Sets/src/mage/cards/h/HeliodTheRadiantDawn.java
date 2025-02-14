package mage.cards.h;

import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.ActivateAsSorceryActivatedAbility;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.ReturnFromGraveyardToHandTargetEffect;
import mage.abilities.effects.common.TransformSourceEffect;
import mage.abilities.keyword.TransformAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.SuperType;
import mage.filter.FilterCard;
import mage.filter.common.FilterEnchantmentCard;
import mage.filter.predicate.Predicates;
import mage.target.common.TargetCardInYourGraveyard;

import java.util.UUID;

public class HeliodTheRadiantDawn extends CardImpl {

    private static final FilterCard filter = new FilterEnchantmentCard("enchantment card that isn't a God");

    static {
        filter.add(Predicates.not(SubType.GOD.getPredicate()));
    }

    public HeliodTheRadiantDawn(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ENCHANTMENT, CardType.CREATURE}, "{2}{W}{W}");
        this.addSuperType(SuperType.LEGENDARY);
        this.addSubType(SubType.GOD);
        this.power = new MageInt(4);
        this.toughness = new MageInt(4);
        this.secondSideCardClazz = mage.cards.h.HeliodTheWarpedEclipse.class;

        // When Heliod, the Radiant Dawn enters the battlefield, return target enchantment card that isn't a God from your graveyard to your hand.
        Ability ability = new EntersBattlefieldTriggeredAbility(new ReturnFromGraveyardToHandTargetEffect());
        ability.addTarget(new TargetCardInYourGraveyard(filter));
        this.addAbility(ability);

        // {3}{U/P}: Transform Heliod, the Radiant Dawn. Activate only as a sorcery.
        this.addAbility(new TransformAbility());
        this.addAbility(new ActivateAsSorceryActivatedAbility(new TransformSourceEffect(), new ManaCostsImpl<>("{3}{U/P}")));
    }

    private HeliodTheRadiantDawn(final HeliodTheRadiantDawn card) {
        super(card);
    }

    @Override
    public HeliodTheRadiantDawn copy() {
        return new HeliodTheRadiantDawn(this);
    }
}
