package net.kumc.lab.multiblockbreak.command;

import dev.kotx.flylib.command.Command;
import kotlin.Unit;

import java.lang.reflect.Field;

public class ConfigItem extends Command {
    public ConfigItem(Field field) {
        super(field.getName());

        String name = field.getName();
        Class clazz = field.getType();

        usage(builder -> {
            if (clazz.equals(Integer.class) || clazz.equals(int.class)) {
                builder.integerArgument(name);
            }

            if (clazz.equals(Double.class) || clazz.equals(double.class)) {
                builder.doubleArgument(name);
            }

            if (clazz.equals(Boolean.class) || clazz.equals(boolean.class)) {
                builder.textArgument("boolean", suggestionBuilder -> {
                    suggestionBuilder.suggest("true");
                    suggestionBuilder.suggest("false");
                });
            }

            builder.executes(ctx -> {
                Object value = ctx.getTypedArgs().get(0);
                String setValue = value.toString();
                try {
                    if (clazz.equals(Boolean.class) || clazz.equals(boolean.class)) {
                        Boolean boolValue = Boolean.parseBoolean(value.toString());
                        field.set(null, boolValue);
                        setValue = boolValue.toString();
                    } else {
                        field.set(null, value);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                ctx.success(name + "の値を" + setValue + "に設定しました.");
                return Unit.INSTANCE;
            });
        });
    }
}
