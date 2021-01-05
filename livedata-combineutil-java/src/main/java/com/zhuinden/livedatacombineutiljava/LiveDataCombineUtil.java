/*
 * Copyright 2021 Gabor Varadi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhuinden.livedatacombineutiljava;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;


public class LiveDataCombineUtil {
    private LiveDataCombineUtil() {
    }

    public interface Combiner2<T1, T2, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2);
    }

    @Nonnull
    public static <T1, T2, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final Combiner2<T1, T2, R> combiner2) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(combiner2 == null) {
            throw new NullPointerException("combiner2 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner2.combine(f1.getValue(), f2.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                mediator.setValue(combiner2.combine(t1, t2));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                mediator.setValue(combiner2.combine(t1, t2));
            }
        });

        return mediator;
    }

    public interface Combiner3<T1, T2, T3, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3);
    }

    @Nonnull
    public static <T1, T2, T3, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final Combiner3<T1, T2, T3, R> combiner3) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(combiner3 == null) {
            throw new NullPointerException("combiner3 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner3.combine(f1.getValue(), f2.getValue(), f3.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                mediator.setValue(combiner3.combine(t1, t2, t3));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                mediator.setValue(combiner3.combine(t1, t2, t3));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                mediator.setValue(combiner3.combine(t1, t2, t3));
            }
        });

        return mediator;
    }

    public interface Combiner4<T1, T2, T3, T4, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4);
    }

    @Nonnull
    public static <T1, T2, T3, T4, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final Combiner4<T1, T2, T3, T4, R> combiner4) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(combiner4 == null) {
            throw new NullPointerException("combiner4 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner4.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                mediator.setValue(combiner4.combine(t1, t2, t3, t4));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                mediator.setValue(combiner4.combine(t1, t2, t3, t4));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                mediator.setValue(combiner4.combine(t1, t2, t3, t4));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                mediator.setValue(combiner4.combine(t1, t2, t3, t4));
            }
        });

        return mediator;
    }

    public interface Combiner5<T1, T2, T3, T4, T5, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final Combiner5<T1, T2, T3, T4, T5, R> combiner5) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(combiner5 == null) {
            throw new NullPointerException("combiner5 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner5.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                mediator.setValue(combiner5.combine(t1, t2, t3, t4, t5));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                mediator.setValue(combiner5.combine(t1, t2, t3, t4, t5));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                mediator.setValue(combiner5.combine(t1, t2, t3, t4, t5));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                mediator.setValue(combiner5.combine(t1, t2, t3, t4, t5));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                mediator.setValue(combiner5.combine(t1, t2, t3, t4, t5));
            }
        });

        return mediator;
    }

    public interface Combiner6<T1, T2, T3, T4, T5, T6, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final Combiner6<T1, T2, T3, T4, T5, T6, R> combiner6) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(combiner6 == null) {
            throw new NullPointerException("combiner6 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner6.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                mediator.setValue(combiner6.combine(t1, t2, t3, t4, t5, t6));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                mediator.setValue(combiner6.combine(t1, t2, t3, t4, t5, t6));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                mediator.setValue(combiner6.combine(t1, t2, t3, t4, t5, t6));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                mediator.setValue(combiner6.combine(t1, t2, t3, t4, t5, t6));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                mediator.setValue(combiner6.combine(t1, t2, t3, t4, t5, t6));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                mediator.setValue(combiner6.combine(t1, t2, t3, t4, t5, t6));
            }
        });

        return mediator;
    }

    public interface Combiner7<T1, T2, T3, T4, T5, T6, T7, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6, @Nullable T7 t7);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, T7, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final LiveData<T7> f7, @Nonnull final Combiner7<T1, T2, T3, T4, T5, T6, T7, R> combiner7) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(f7 == null) {
            throw new NullPointerException("f7 should not be null");
        }
        if(combiner7 == null) {
            throw new NullPointerException("combiner7 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner7.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue(), f7.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                mediator.setValue(combiner7.combine(t1, t2, t3, t4, t5, t6, t7));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                mediator.setValue(combiner7.combine(t1, t2, t3, t4, t5, t6, t7));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                mediator.setValue(combiner7.combine(t1, t2, t3, t4, t5, t6, t7));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                mediator.setValue(combiner7.combine(t1, t2, t3, t4, t5, t6, t7));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                mediator.setValue(combiner7.combine(t1, t2, t3, t4, t5, t6, t7));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T7 t7 = f7.getValue();
                mediator.setValue(combiner7.combine(t1, t2, t3, t4, t5, t6, t7));
            }
        });

        mediator.addSource(f7, new Observer<T7>() {
            @Override
            public void onChanged(T7 t7) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                mediator.setValue(combiner7.combine(t1, t2, t3, t4, t5, t6, t7));
            }
        });

        return mediator;
    }

    public interface Combiner8<T1, T2, T3, T4, T5, T6, T7, T8, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6, @Nullable T7 t7, @Nullable T8 t8);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final LiveData<T7> f7, @Nonnull final LiveData<T8> f8, @Nonnull final Combiner8<T1, T2, T3, T4, T5, T6, T7, T8, R> combiner8) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(f7 == null) {
            throw new NullPointerException("f7 should not be null");
        }
        if(f8 == null) {
            throw new NullPointerException("f8 should not be null");
        }
        if(combiner8 == null) {
            throw new NullPointerException("combiner8 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner8.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue(), f7.getValue(), f8.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                mediator.setValue(combiner8.combine(t1, t2, t3, t4, t5, t6, t7, t8));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                mediator.setValue(combiner8.combine(t1, t2, t3, t4, t5, t6, t7, t8));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                mediator.setValue(combiner8.combine(t1, t2, t3, t4, t5, t6, t7, t8));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                mediator.setValue(combiner8.combine(t1, t2, t3, t4, t5, t6, t7, t8));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                mediator.setValue(combiner8.combine(t1, t2, t3, t4, t5, t6, t7, t8));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                mediator.setValue(combiner8.combine(t1, t2, t3, t4, t5, t6, t7, t8));
            }
        });

        mediator.addSource(f7, new Observer<T7>() {
            @Override
            public void onChanged(T7 t7) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T8 t8 = f8.getValue();
                mediator.setValue(combiner8.combine(t1, t2, t3, t4, t5, t6, t7, t8));
            }
        });

        mediator.addSource(f8, new Observer<T8>() {
            @Override
            public void onChanged(T8 t8) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                mediator.setValue(combiner8.combine(t1, t2, t3, t4, t5, t6, t7, t8));
            }
        });

        return mediator;
    }

    public interface Combiner9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6, @Nullable T7 t7, @Nullable T8 t8, @Nullable T9 t9);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final LiveData<T7> f7, @Nonnull final LiveData<T8> f8, @Nonnull final LiveData<T9> f9, @Nonnull final Combiner9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> combiner9) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(f7 == null) {
            throw new NullPointerException("f7 should not be null");
        }
        if(f8 == null) {
            throw new NullPointerException("f8 should not be null");
        }
        if(f9 == null) {
            throw new NullPointerException("f9 should not be null");
        }
        if(combiner9 == null) {
            throw new NullPointerException("combiner9 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner9.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue(), f7.getValue(), f8.getValue(), f9.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                mediator.setValue(combiner9.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                mediator.setValue(combiner9.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                mediator.setValue(combiner9.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                mediator.setValue(combiner9.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                mediator.setValue(combiner9.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                mediator.setValue(combiner9.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9));
            }
        });

        mediator.addSource(f7, new Observer<T7>() {
            @Override
            public void onChanged(T7 t7) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                mediator.setValue(combiner9.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9));
            }
        });

        mediator.addSource(f8, new Observer<T8>() {
            @Override
            public void onChanged(T8 t8) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T9 t9 = f9.getValue();
                mediator.setValue(combiner9.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9));
            }
        });

        mediator.addSource(f9, new Observer<T9>() {
            @Override
            public void onChanged(T9 t9) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                mediator.setValue(combiner9.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9));
            }
        });

        return mediator;
    }

    public interface Combiner10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6, @Nullable T7 t7, @Nullable T8 t8, @Nullable T9 t9, @Nullable T10 t10);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final LiveData<T7> f7, @Nonnull final LiveData<T8> f8, @Nonnull final LiveData<T9> f9, @Nonnull final LiveData<T10> f10, @Nonnull final Combiner10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> combiner10) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(f7 == null) {
            throw new NullPointerException("f7 should not be null");
        }
        if(f8 == null) {
            throw new NullPointerException("f8 should not be null");
        }
        if(f9 == null) {
            throw new NullPointerException("f9 should not be null");
        }
        if(f10 == null) {
            throw new NullPointerException("f10 should not be null");
        }
        if(combiner10 == null) {
            throw new NullPointerException("combiner10 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner10.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue(), f7.getValue(), f8.getValue(), f9.getValue(), f10.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                mediator.setValue(combiner10.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                mediator.setValue(combiner10.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                mediator.setValue(combiner10.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                mediator.setValue(combiner10.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                mediator.setValue(combiner10.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                mediator.setValue(combiner10.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
            }
        });

        mediator.addSource(f7, new Observer<T7>() {
            @Override
            public void onChanged(T7 t7) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                mediator.setValue(combiner10.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
            }
        });

        mediator.addSource(f8, new Observer<T8>() {
            @Override
            public void onChanged(T8 t8) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                mediator.setValue(combiner10.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
            }
        });

        mediator.addSource(f9, new Observer<T9>() {
            @Override
            public void onChanged(T9 t9) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T10 t10 = f10.getValue();
                mediator.setValue(combiner10.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
            }
        });

        mediator.addSource(f10, new Observer<T10>() {
            @Override
            public void onChanged(T10 t10) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                mediator.setValue(combiner10.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
            }
        });

        return mediator;
    }

    public interface Combiner11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6, @Nullable T7 t7, @Nullable T8 t8, @Nullable T9 t9, @Nullable T10 t10, @Nullable T11 t11);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final LiveData<T7> f7, @Nonnull final LiveData<T8> f8, @Nonnull final LiveData<T9> f9, @Nonnull final LiveData<T10> f10, @Nonnull final LiveData<T11> f11, @Nonnull final Combiner11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> combiner11) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(f7 == null) {
            throw new NullPointerException("f7 should not be null");
        }
        if(f8 == null) {
            throw new NullPointerException("f8 should not be null");
        }
        if(f9 == null) {
            throw new NullPointerException("f9 should not be null");
        }
        if(f10 == null) {
            throw new NullPointerException("f10 should not be null");
        }
        if(f11 == null) {
            throw new NullPointerException("f11 should not be null");
        }
        if(combiner11 == null) {
            throw new NullPointerException("combiner11 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner11.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue(), f7.getValue(), f8.getValue(), f9.getValue(), f10.getValue(), f11.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        mediator.addSource(f7, new Observer<T7>() {
            @Override
            public void onChanged(T7 t7) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        mediator.addSource(f8, new Observer<T8>() {
            @Override
            public void onChanged(T8 t8) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        mediator.addSource(f9, new Observer<T9>() {
            @Override
            public void onChanged(T9 t9) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        mediator.addSource(f10, new Observer<T10>() {
            @Override
            public void onChanged(T10 t10) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        mediator.addSource(f11, new Observer<T11>() {
            @Override
            public void onChanged(T11 t11) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                mediator.setValue(combiner11.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
            }
        });

        return mediator;
    }

    public interface Combiner12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6, @Nullable T7 t7, @Nullable T8 t8, @Nullable T9 t9, @Nullable T10 t10, @Nullable T11 t11, @Nullable T12 t12);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final LiveData<T7> f7, @Nonnull final LiveData<T8> f8, @Nonnull final LiveData<T9> f9, @Nonnull final LiveData<T10> f10, @Nonnull final LiveData<T11> f11, @Nonnull final LiveData<T12> f12, @Nonnull final Combiner12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> combiner12) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(f7 == null) {
            throw new NullPointerException("f7 should not be null");
        }
        if(f8 == null) {
            throw new NullPointerException("f8 should not be null");
        }
        if(f9 == null) {
            throw new NullPointerException("f9 should not be null");
        }
        if(f10 == null) {
            throw new NullPointerException("f10 should not be null");
        }
        if(f11 == null) {
            throw new NullPointerException("f11 should not be null");
        }
        if(f12 == null) {
            throw new NullPointerException("f12 should not be null");
        }
        if(combiner12 == null) {
            throw new NullPointerException("combiner12 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner12.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue(), f7.getValue(), f8.getValue(), f9.getValue(), f10.getValue(), f11.getValue(), f12.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f7, new Observer<T7>() {
            @Override
            public void onChanged(T7 t7) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f8, new Observer<T8>() {
            @Override
            public void onChanged(T8 t8) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f9, new Observer<T9>() {
            @Override
            public void onChanged(T9 t9) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f10, new Observer<T10>() {
            @Override
            public void onChanged(T10 t10) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f11, new Observer<T11>() {
            @Override
            public void onChanged(T11 t11) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        mediator.addSource(f12, new Observer<T12>() {
            @Override
            public void onChanged(T12 t12) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                mediator.setValue(combiner12.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        });

        return mediator;
    }

    public interface Combiner13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6, @Nullable T7 t7, @Nullable T8 t8, @Nullable T9 t9, @Nullable T10 t10, @Nullable T11 t11, @Nullable T12 t12, @Nullable T13 t13);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final LiveData<T7> f7, @Nonnull final LiveData<T8> f8, @Nonnull final LiveData<T9> f9, @Nonnull final LiveData<T10> f10, @Nonnull final LiveData<T11> f11, @Nonnull final LiveData<T12> f12, @Nonnull final LiveData<T13> f13, @Nonnull final Combiner13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> combiner13) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(f7 == null) {
            throw new NullPointerException("f7 should not be null");
        }
        if(f8 == null) {
            throw new NullPointerException("f8 should not be null");
        }
        if(f9 == null) {
            throw new NullPointerException("f9 should not be null");
        }
        if(f10 == null) {
            throw new NullPointerException("f10 should not be null");
        }
        if(f11 == null) {
            throw new NullPointerException("f11 should not be null");
        }
        if(f12 == null) {
            throw new NullPointerException("f12 should not be null");
        }
        if(f13 == null) {
            throw new NullPointerException("f13 should not be null");
        }
        if(combiner13 == null) {
            throw new NullPointerException("combiner13 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner13.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue(), f7.getValue(), f8.getValue(), f9.getValue(), f10.getValue(), f11.getValue(), f12.getValue(), f13.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f7, new Observer<T7>() {
            @Override
            public void onChanged(T7 t7) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f8, new Observer<T8>() {
            @Override
            public void onChanged(T8 t8) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f9, new Observer<T9>() {
            @Override
            public void onChanged(T9 t9) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f10, new Observer<T10>() {
            @Override
            public void onChanged(T10 t10) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f11, new Observer<T11>() {
            @Override
            public void onChanged(T11 t11) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f12, new Observer<T12>() {
            @Override
            public void onChanged(T12 t12) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        mediator.addSource(f13, new Observer<T13>() {
            @Override
            public void onChanged(T13 t13) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                mediator.setValue(combiner13.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13));
            }
        });

        return mediator;
    }

    public interface Combiner14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6, @Nullable T7 t7, @Nullable T8 t8, @Nullable T9 t9, @Nullable T10 t10, @Nullable T11 t11, @Nullable T12 t12, @Nullable T13 t13, @Nullable T14 t14);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final LiveData<T7> f7, @Nonnull final LiveData<T8> f8, @Nonnull final LiveData<T9> f9, @Nonnull final LiveData<T10> f10, @Nonnull final LiveData<T11> f11, @Nonnull final LiveData<T12> f12, @Nonnull final LiveData<T13> f13, @Nonnull final LiveData<T14> f14, @Nonnull final Combiner14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> combiner14) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(f7 == null) {
            throw new NullPointerException("f7 should not be null");
        }
        if(f8 == null) {
            throw new NullPointerException("f8 should not be null");
        }
        if(f9 == null) {
            throw new NullPointerException("f9 should not be null");
        }
        if(f10 == null) {
            throw new NullPointerException("f10 should not be null");
        }
        if(f11 == null) {
            throw new NullPointerException("f11 should not be null");
        }
        if(f12 == null) {
            throw new NullPointerException("f12 should not be null");
        }
        if(f13 == null) {
            throw new NullPointerException("f13 should not be null");
        }
        if(f14 == null) {
            throw new NullPointerException("f14 should not be null");
        }
        if(combiner14 == null) {
            throw new NullPointerException("combiner14 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner14.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue(), f7.getValue(), f8.getValue(), f9.getValue(), f10.getValue(), f11.getValue(), f12.getValue(), f13.getValue(), f14.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f7, new Observer<T7>() {
            @Override
            public void onChanged(T7 t7) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f8, new Observer<T8>() {
            @Override
            public void onChanged(T8 t8) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f9, new Observer<T9>() {
            @Override
            public void onChanged(T9 t9) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f10, new Observer<T10>() {
            @Override
            public void onChanged(T10 t10) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f11, new Observer<T11>() {
            @Override
            public void onChanged(T11 t11) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f12, new Observer<T12>() {
            @Override
            public void onChanged(T12 t12) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f13, new Observer<T13>() {
            @Override
            public void onChanged(T13 t13) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        mediator.addSource(f14, new Observer<T14>() {
            @Override
            public void onChanged(T14 t14) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                mediator.setValue(combiner14.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14));
            }
        });

        return mediator;
    }

    public interface Combiner15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6, @Nullable T7 t7, @Nullable T8 t8, @Nullable T9 t9, @Nullable T10 t10, @Nullable T11 t11, @Nullable T12 t12, @Nullable T13 t13, @Nullable T14 t14, @Nullable T15 t15);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final LiveData<T7> f7, @Nonnull final LiveData<T8> f8, @Nonnull final LiveData<T9> f9, @Nonnull final LiveData<T10> f10, @Nonnull final LiveData<T11> f11, @Nonnull final LiveData<T12> f12, @Nonnull final LiveData<T13> f13, @Nonnull final LiveData<T14> f14, @Nonnull final LiveData<T15> f15, @Nonnull final Combiner15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> combiner15) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(f7 == null) {
            throw new NullPointerException("f7 should not be null");
        }
        if(f8 == null) {
            throw new NullPointerException("f8 should not be null");
        }
        if(f9 == null) {
            throw new NullPointerException("f9 should not be null");
        }
        if(f10 == null) {
            throw new NullPointerException("f10 should not be null");
        }
        if(f11 == null) {
            throw new NullPointerException("f11 should not be null");
        }
        if(f12 == null) {
            throw new NullPointerException("f12 should not be null");
        }
        if(f13 == null) {
            throw new NullPointerException("f13 should not be null");
        }
        if(f14 == null) {
            throw new NullPointerException("f14 should not be null");
        }
        if(f15 == null) {
            throw new NullPointerException("f15 should not be null");
        }
        if(combiner15 == null) {
            throw new NullPointerException("combiner15 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner15.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue(), f7.getValue(), f8.getValue(), f9.getValue(), f10.getValue(), f11.getValue(), f12.getValue(), f13.getValue(), f14.getValue(), f15.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f7, new Observer<T7>() {
            @Override
            public void onChanged(T7 t7) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f8, new Observer<T8>() {
            @Override
            public void onChanged(T8 t8) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f9, new Observer<T9>() {
            @Override
            public void onChanged(T9 t9) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f10, new Observer<T10>() {
            @Override
            public void onChanged(T10 t10) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f11, new Observer<T11>() {
            @Override
            public void onChanged(T11 t11) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f12, new Observer<T12>() {
            @Override
            public void onChanged(T12 t12) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f13, new Observer<T13>() {
            @Override
            public void onChanged(T13 t13) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f14, new Observer<T14>() {
            @Override
            public void onChanged(T14 t14) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        mediator.addSource(f15, new Observer<T15>() {
            @Override
            public void onChanged(T15 t15) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                mediator.setValue(combiner15.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15));
            }
        });

        return mediator;
    }

    public interface Combiner16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> {
        @Nullable
        R combine(@Nullable T1 t1, @Nullable T2 t2, @Nullable T3 t3, @Nullable T4 t4, @Nullable T5 t5, @Nullable T6 t6, @Nullable T7 t7, @Nullable T8 t8, @Nullable T9 t9, @Nullable T10 t10, @Nullable T11 t11, @Nullable T12 t12, @Nullable T13 t13, @Nullable T14 t14, @Nullable T15 t15, @Nullable T16 t16);
    }

    @Nonnull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> LiveData<R> combine(@Nonnull final LiveData<T1> f1, @Nonnull final LiveData<T2> f2, @Nonnull final LiveData<T3> f3, @Nonnull final LiveData<T4> f4, @Nonnull final LiveData<T5> f5, @Nonnull final LiveData<T6> f6, @Nonnull final LiveData<T7> f7, @Nonnull final LiveData<T8> f8, @Nonnull final LiveData<T9> f9, @Nonnull final LiveData<T10> f10, @Nonnull final LiveData<T11> f11, @Nonnull final LiveData<T12> f12, @Nonnull final LiveData<T13> f13, @Nonnull final LiveData<T14> f14, @Nonnull final LiveData<T15> f15, @Nonnull final LiveData<T16> f16, @Nonnull final Combiner16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> combiner16) {
        if(f1 == null) {
            throw new NullPointerException("f1 should not be null");
        }
        if(f2 == null) {
            throw new NullPointerException("f2 should not be null");
        }
        if(f3 == null) {
            throw new NullPointerException("f3 should not be null");
        }
        if(f4 == null) {
            throw new NullPointerException("f4 should not be null");
        }
        if(f5 == null) {
            throw new NullPointerException("f5 should not be null");
        }
        if(f6 == null) {
            throw new NullPointerException("f6 should not be null");
        }
        if(f7 == null) {
            throw new NullPointerException("f7 should not be null");
        }
        if(f8 == null) {
            throw new NullPointerException("f8 should not be null");
        }
        if(f9 == null) {
            throw new NullPointerException("f9 should not be null");
        }
        if(f10 == null) {
            throw new NullPointerException("f10 should not be null");
        }
        if(f11 == null) {
            throw new NullPointerException("f11 should not be null");
        }
        if(f12 == null) {
            throw new NullPointerException("f12 should not be null");
        }
        if(f13 == null) {
            throw new NullPointerException("f13 should not be null");
        }
        if(f14 == null) {
            throw new NullPointerException("f14 should not be null");
        }
        if(f15 == null) {
            throw new NullPointerException("f15 should not be null");
        }
        if(f16 == null) {
            throw new NullPointerException("f16 should not be null");
        }
        if(combiner16 == null) {
            throw new NullPointerException("combiner16 should not be null");
        }

        final MediatorLiveData<R> mediator = new MediatorLiveData<>();

        mediator.setValue(combiner16.combine(f1.getValue(), f2.getValue(), f3.getValue(), f4.getValue(), f5.getValue(), f6.getValue(), f7.getValue(), f8.getValue(), f9.getValue(), f10.getValue(), f11.getValue(), f12.getValue(), f13.getValue(), f14.getValue(), f15.getValue(), f16.getValue()));

        mediator.addSource(f1, new Observer<T1>() {
            @Override
            public void onChanged(T1 t1) {
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f2, new Observer<T2>() {
            @Override
            public void onChanged(T2 t2) {
                final T1 t1 = f1.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f3, new Observer<T3>() {
            @Override
            public void onChanged(T3 t3) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f4, new Observer<T4>() {
            @Override
            public void onChanged(T4 t4) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f5, new Observer<T5>() {
            @Override
            public void onChanged(T5 t5) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f6, new Observer<T6>() {
            @Override
            public void onChanged(T6 t6) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f7, new Observer<T7>() {
            @Override
            public void onChanged(T7 t7) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f8, new Observer<T8>() {
            @Override
            public void onChanged(T8 t8) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f9, new Observer<T9>() {
            @Override
            public void onChanged(T9 t9) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f10, new Observer<T10>() {
            @Override
            public void onChanged(T10 t10) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f11, new Observer<T11>() {
            @Override
            public void onChanged(T11 t11) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f12, new Observer<T12>() {
            @Override
            public void onChanged(T12 t12) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f13, new Observer<T13>() {
            @Override
            public void onChanged(T13 t13) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f14, new Observer<T14>() {
            @Override
            public void onChanged(T14 t14) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T15 t15 = f15.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f15, new Observer<T15>() {
            @Override
            public void onChanged(T15 t15) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T16 t16 = f16.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        mediator.addSource(f16, new Observer<T16>() {
            @Override
            public void onChanged(T16 t16) {
                final T1 t1 = f1.getValue();
                final T2 t2 = f2.getValue();
                final T3 t3 = f3.getValue();
                final T4 t4 = f4.getValue();
                final T5 t5 = f5.getValue();
                final T6 t6 = f6.getValue();
                final T7 t7 = f7.getValue();
                final T8 t8 = f8.getValue();
                final T9 t9 = f9.getValue();
                final T10 t10 = f10.getValue();
                final T11 t11 = f11.getValue();
                final T12 t12 = f12.getValue();
                final T13 t13 = f13.getValue();
                final T14 t14 = f14.getValue();
                final T15 t15 = f15.getValue();
                mediator.setValue(combiner16.combine(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16));
            }
        });

        return mediator;
    }

    @Nonnull
    public static LiveData<Object[]> combineArray(@Nonnull final LiveData<?>... liveDatas) {
        final Object[] initialValues = new Object[liveDatas.length];

        for(int i = 0; i < liveDatas.length; i++) {
            final LiveData<?> liveData = liveDatas[i];

            if(liveData == null) {
                throw new NullPointerException("liveData[" + i + "] should not be null!");
            }

            initialValues[i] = liveData.getValue();
        }

        final MediatorLiveData<Object[]> mediator = new MediatorLiveData<>();

        mediator.setValue(initialValues);

        for(int i = 0; i < liveDatas.length; i++) {
            final LiveData<?> liveData = liveDatas[i];

            final int currentIndex = i;

            mediator.addSource(liveData, new Observer<Object>() {
                @Override
                public void onChanged(Object o) {
                    final Object[] values = new Object[liveDatas.length];

                    for(int j = 0; j < liveDatas.length; j++) {
                        if(currentIndex != j) {
                            values[j] = liveDatas[j].getValue();
                        } else {
                            values[j] = o;
                        }
                    }

                    mediator.setValue(values);
                }
            });
        }

        return mediator;
    }
}